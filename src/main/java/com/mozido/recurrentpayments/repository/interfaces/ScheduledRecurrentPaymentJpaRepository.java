package com.mozido.recurrentpayments.repository.interfaces;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledRecurrentPaymentJpaRepository
        extends JpaRepository<ScheduledRecurrentPayment, Long> {
    List<ScheduledRecurrentPayment> findByStatus(PaymentStatus status);
}
