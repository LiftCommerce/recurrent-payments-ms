package com.mozido.recurrentpayments.repository;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExecutedScheduledRecurrentPaymentRepository extends JpaRepository<ExecutedScheduledRecurrentPayment, Long>
{

}
