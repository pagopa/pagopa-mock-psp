package it.gov.pagopa.paypalpsp.internalcontroller;


import it.gov.pagopa.db.entity.TablePpOnboardingBack;
import it.gov.pagopa.db.entity.TableUserPayPal;
import it.gov.pagopa.db.repository.TableUserPayPalRepository;
import it.gov.pagopa.paypalpsp.PaypalUtils;
import it.gov.pagopa.paypalpsp.dto.dtoenum.PpOnboardingCallResponseErrCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.UUID;

@Log4j2
@Controller
@RequestMapping("/paypalweb/management")
public class PayPalWebManagementController {
    private static final String REDIRECT_PAYPALWEB_PP_ONBOARDING_CALL_ID_BACK_UNKNOWN = "redirect:/paypalweb/pp_onboarding_call?id_back=unknown";

    @Autowired
    private TableUserPayPalRepository tableUserPayPalRepository;

    @Autowired
    private PaypalUtils paypalUtils;

    //ONLY INTERNAL API - NOT INCLUDED IN PRODUCTION ENV
    @PostMapping("/success")
    public String success(SessionStatus sessionStatus, @RequestParam String paypalEmail, @RequestParam String paypalId, @SessionAttribute(required = false) TablePpOnboardingBack tablePpOnboardingBack) {
        try {
            if (tablePpOnboardingBack == null) {
                return REDIRECT_PAYPALWEB_PP_ONBOARDING_CALL_ID_BACK_UNKNOWN;
            }
            String urlReturn = tablePpOnboardingBack.getUrlReturn();
            String idAppIo = tablePpOnboardingBack.getIdAppIo();
            TableUserPayPal tableUserPayPal = TableUserPayPal.builder()
                    .idAppIo(idAppIo)
                    .paypalEmail(paypalEmail)
                    .paypalId(paypalId)
                    .contractNumber(UUID.randomUUID().toString()).build();
            log.info("Trying to create contract: " + tableUserPayPal);
            tableUserPayPal = tableUserPayPalRepository.save(tableUserPayPal);
            log.info("New Contract established: " + tableUserPayPal);

            String esito = "1";
            String emailPpObfuscated = paypalEmail.replaceAll("\\b(\\w{3})[^@]+@\\S+(\\.[^\\s.]+)", "$1***@****$2");
            String hmac = paypalUtils.calculateHmac(esito, paypalId, emailPpObfuscated, null, tablePpOnboardingBack.getIdBack());
            String redirectUrl = String.format("redirect:%s?esito=%s&id_pp=%s&email_pp=%s&sha_val=%s",
                    urlReturn, esito, paypalId, emailPpObfuscated, hmac);
            log.info(String.format("Success paypal redirect for user id: '%s' and redirect url '%s'", idAppIo, redirectUrl));
            return redirectUrl;
        } finally {
            sessionStatus.setComplete();
        }
    }

    //ONLY INTERNAL API - NOT INCLUDED IN PRODUCTION ENV
    @GetMapping("/cancel")
    public String cancel(SessionStatus sessionStatus, @SessionAttribute(required = false) TablePpOnboardingBack tablePpOnboardingBack) {
        try {
            if (tablePpOnboardingBack == null) {
                return REDIRECT_PAYPALWEB_PP_ONBOARDING_CALL_ID_BACK_UNKNOWN;
            }
            String esito = "3";
            String hmac = paypalUtils.calculateHmac(esito, null, null, null, tablePpOnboardingBack.getIdBack());
            String redirectUrl = String.format("redirect:%s?esito=%s&sha_val=%s", tablePpOnboardingBack.getUrlReturn(), esito, hmac);
            log.info(String.format("Cancel paypal redirect for user id: '%s' and redirect url '%s'", tablePpOnboardingBack.getIdAppIo(), redirectUrl));
            return redirectUrl;
        } finally {
            sessionStatus.setComplete();
        }
    }

    //ONLY INTERNAL API - NOT INCLUDED IN PRODUCTION ENV
    @GetMapping("/error/{errCode}")
    public String error(@PathVariable String errCode, SessionStatus sessionStatus, @SessionAttribute(required = false) TablePpOnboardingBack tablePpOnboardingBack) {
        try {
            if (tablePpOnboardingBack == null) {
                return REDIRECT_PAYPALWEB_PP_ONBOARDING_CALL_ID_BACK_UNKNOWN;
            }
            PpOnboardingCallResponseErrCode callResponseErrCode = PpOnboardingCallResponseErrCode.of(errCode);

            String esito = "9";
            String hmac = paypalUtils.calculateHmac(esito, null, null, callResponseErrCode, tablePpOnboardingBack.getIdBack());
            String redirectUrl = String.format("redirect:%s?esito=%s&err_cod=%s&err_desc=%s&sha_val=%s",
                    tablePpOnboardingBack.getUrlReturn(), esito, callResponseErrCode.getCode(), callResponseErrCode.getDescription(), hmac);
            log.info(String.format("Error paypal redirect for user id: '%s' and redirect url '%s'", tablePpOnboardingBack.getIdAppIo(), redirectUrl));
            return redirectUrl;
        } finally {
            sessionStatus.setComplete();
        }
    }
}
