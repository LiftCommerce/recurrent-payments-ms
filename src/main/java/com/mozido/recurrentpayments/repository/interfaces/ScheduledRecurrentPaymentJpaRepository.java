package com.mozido.recurrentpayments.repository.interfaces;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduledRecurrentPaymentJpaRepository
        extends JpaRepository<ScheduledRecurrentPayment, Long> {
    List<ScheduledRecurrentPayment> findByStatus(PaymentStatus status);

    @Query("SELECT p FROM ScheduledRecurrentPayment p WHERE p.status = 'ACTIVE'")
    List<ScheduledRecurrentPayment> findAllActive();
}
