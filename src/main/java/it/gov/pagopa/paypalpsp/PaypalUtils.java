package it.gov.pagopa.paypalpsp;

import com.google.common.hash.Hashing;
import it.gov.pagopa.db.repository.TableConfigRepository;
import it.gov.pagopa.paypalpsp.dto.dtoenum.PpOnboardingCallResponseErrCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class PaypalUtils {
    @Autowired
    private TableConfigRepository tableConfigRepository;

    @SuppressWarnings("UnstableApiUsage")
    public String calculateHmac(String esito, String idPp, String emailPp, PpOnboardingCallResponseErrCode errCodeEnum, String idBack) {
        String errCode = errCodeEnum != null ? errCodeEnum.getCode() : "";
        String errDesc = errCodeEnum != null ? errCodeEnum.getDescription() : "";
        String result = String.format(StringUtils.joinWith("=%s&", "esito", "id_pp", "email_pp", "err_cod", "err_desc", "id_back"), esito, StringUtils.defaultString(idPp), StringUtils.defaultString(emailPp), StringUtils.defaultString(errCode), StringUtils.defaultString(errDesc), idBack);
        String paypalPspHmacKey = tableConfigRepository.findByPropertyKey("PAYPAL_PSP_HMAC_KEY").getPropertyValue();
        return Hashing.hmacSha256(paypalPspHmacKey.getBytes()).hashString(result, StandardCharsets.UTF_8).toString();
    }

    public String obfuscateEmail(String email) {
        if (StringUtils.isNotBlank(email))
            email = email.replaceAll("\\b(\\w{3})[^@]+@\\S+(\\.[^\\s.]+)", "$1***@****$2");

        return email;
    }
}
