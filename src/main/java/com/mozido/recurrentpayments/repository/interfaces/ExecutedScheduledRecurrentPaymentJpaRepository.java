package com.mozido.recurrentpayments.repository.interfaces;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutedScheduledRecurrentPaymentJpaRepository
        extends JpaRepository<ExecutedScheduledRecurrentPayment, Long> {
}
