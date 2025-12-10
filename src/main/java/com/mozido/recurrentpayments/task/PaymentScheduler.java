package com.mozido.recurrentpayments.task;

import com.mozido.recurrentpayments.bussines.ScheduledRecurrentPaymentBs;
import com.mozido.recurrentpayments.exception.ControllerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Rafael Richards on 06/25.
 */

@Component
public class PaymentScheduler {
    @Autowired
    private ScheduledRecurrentPaymentBs scheduledRecurrentPaymentBs;

    public void runPaymentJob() throws ControllerException {
        scheduledRecurrentPaymentBs.processDuePayments(LocalDate.now());
    }
}
