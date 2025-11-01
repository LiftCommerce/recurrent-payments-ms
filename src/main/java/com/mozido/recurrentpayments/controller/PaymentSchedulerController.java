package com.mozido.recurrentpayments.controller;

import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.task.PaymentScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class PaymentSchedulerController {

    @Autowired
    private PaymentScheduler paymentScheduler;

    @PostMapping("/run")
    public String runPaymentScheduler() throws ControllerException {
        paymentScheduler.runPaymentJob();
        return "Payment scheduler triggered manually.";
    }
}
