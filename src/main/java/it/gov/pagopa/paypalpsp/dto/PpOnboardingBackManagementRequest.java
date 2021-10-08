package it.gov.pagopa.paypalpsp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.gov.pagopa.db.entityenum.ApiPaypalIdEnum;
import it.gov.pagopa.paypalpsp.dto.dtoenum.PpResponseErrCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PpOnboardingBackManagementRequest {
    @NotNull
    @JsonProperty("id_appio")
    private String idAppIo;

    @JsonProperty("err_code")
    private PpResponseErrCode errCode;

    @NotNull
    @JsonProperty("api_id")
    private ApiPaypalIdEnum apiId;
}