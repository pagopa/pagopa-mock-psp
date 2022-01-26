package it.gov.pagopa.bpay.client;

import feign.*;
import it.gov.pagopa.bpay.dto.*;

@Headers({"Content-Type: application/json"})
public interface PmClient {

    @RequestLine("PUT /requestPayment/bancomatPay/{id}")
    void updateTransaction(@Param String id, TransactionUpdateRequest transactionUpdateRequest);

}
