package com.mozido.recurrentpayments.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController
{
    @GetMapping("/health")
    public String health()
    {
        return "OK - recurrent-payments-ms is alive!";
    }
}

