package it.gov.pagopa.db.entity;

import it.gov.pagopa.db.entityenum.ApiPaypalIdEnum;
import it.gov.pagopa.paypalpsp.dto.dtoenum.PpOnboardingBackResponseErrCode;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "pp_paypal_management")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TablePpPaypalManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_appio")
    private String idAppIo; 
    
    @Column(name = "api_id")
    @Enumerated(EnumType.STRING)
    private ApiPaypalIdEnum apiId;

    @Builder.Default
    @Column(name = "lastUpdateDate")
    private Instant lastUpdateDate = Instant.now();

    @Column(name = "err_code")
    private String errCodeValue;
}