package it.gov.pagopa.paypalpsp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PpOnboardingBackResponse extends PpDefaultErrorResponse {
    @JsonProperty("url_to_call")
    private String urlToCall;

    @JsonProperty("id_pp")
    private String idPp;

    @JsonProperty("email_pp")
    private String emailPp;
}
