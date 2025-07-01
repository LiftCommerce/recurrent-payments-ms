package com.mozido.recurrentpayments.task;

import com.mozido.recurrentpayments.bussines.ScheduledRecurrentPaymentBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component

/**
 * Created by Rafael Richards on 06/25.
 */

public class PaymentScheduler {
    @Autowired
    private ScheduledRecurrentPaymentBs scheduledRecurrentPaymentBs;

    @Scheduled(cron = "0 0 9 * * *") // 9:00 AM todos los días
    public void runPaymentJob() {
        scheduledRecurrentPaymentBs.processDuePayments(LocalDate.now());
    }
}
