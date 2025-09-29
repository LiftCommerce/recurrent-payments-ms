package com.mozido.recurrentpayments.controller.v1;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduled-recurrent-payments/scheduler")
public class PaymentSchedulerController {

    @Autowired
    private PaymentScheduler paymentScheduler;

    @PostMapping("/run")
    public String runPaymentScheduler() {
        paymentScheduler.runPaymentJob();
        return "Payment scheduler triggered manually.";
    }
}
