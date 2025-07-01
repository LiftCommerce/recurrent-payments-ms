package com.mozido.recurrentpayments.repository;

import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

public interface ScheduledRecurrentPaymentRepository extends JpaRepository<ScheduledRecurrentPayment, Long> {
    List<ScheduledRecurrentPayment> findByUserId(String userId);
    List<ScheduledRecurrentPayment> findByStatus(PaymentStatus status);
    List<ScheduledRecurrentPayment> findByUserIdAndStatus(String userId, PaymentStatus status);
    @Query("SELECT s FROM ScheduledRecurrentPayment s WHERE " +
            "(:userId IS NULL OR s.userId = :userId) AND " +
            "(:status IS NULL OR s.status = :status) AND " +
            "(:startDate IS NULL OR s.startDate >= :startDate) AND " +
            "(:endDate IS NULL OR s.endDate <= :endDate)")
    Page<ScheduledRecurrentPayment> findByFilters(@Param("userId") String userId,
                                                  @Param("status") PaymentStatus status,
                                                  @Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate,
                                                  Pageable pageable);

}
