package com.mozido.recurrentpayments.model.response;

import com.mozido.recurrentpayments.model.Payment;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by Adaulfo on 11/2023.
 */
public class ContributeEventResponse extends BaseResponse {

    @Schema(description = "Contribute event response")
    private Payment payment;

    public ContributeEventResponse(Payment payment) {
        super();
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
