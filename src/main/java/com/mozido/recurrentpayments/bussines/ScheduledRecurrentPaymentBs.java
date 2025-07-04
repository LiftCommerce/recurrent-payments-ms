package com.mozido.recurrentpayments.bussines;

import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentType;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.request.ScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.Filters.ScheduledRecurrentPaymentFilter;
import com.mozido.recurrentpayments.repository.ScheduledRecurrentPaymentFilterRepository;
import com.mozido.recurrentpayments.repository.interfaces.ScheduledRecurrentPaymentJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

@Service
public class ScheduledRecurrentPaymentBs {


    private ScheduledRecurrentPaymentFilterRepository scheduledRecurrentPaymentFilterRepository;
    private ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository;


    @Autowired
    public ScheduledRecurrentPaymentBs(ScheduledRecurrentPaymentFilterRepository scheduledRecurrentPaymentFilterRepository,
                                       ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository)
    {
        this.scheduledRecurrentPaymentFilterRepository = scheduledRecurrentPaymentFilterRepository;
        this.scheduledRecurrentPaymentJpaRepository = scheduledRecurrentPaymentJpaRepository;
    }

    public ScheduledRecurrentPaymentResponse create(MozidoTrxRequest mozidoTrxRequest, ScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment newEntity = new ScheduledRecurrentPayment();

        newEntity.setTenantName(request.tenantName);
        newEntity.setUserId(request.userId);
        newEntity.setAmount(request.amount);
        newEntity.setStartDate(request.startDate);
        newEntity.setEndDate(request.endDate);
        newEntity.setEndAfter(request.endAfter);
        newEntity.setType(request.type);
        newEntity.setFrequency(request.frequency);
        newEntity.setStatus(request.status);
        newEntity.setCancelUserId(request.cancelUserId);
        newEntity.setCancelDateTime(request.cancelDateTime);
        newEntity.setUserAccepted(request.userAccepted);
        newEntity.setUserDecline(request.userDecline);
        newEntity.setUserSuppressReminders(request.userSuppressReminders);
        newEntity.setPendingSenderApproval(request.pendingSenderApproval);
        newEntity.setLastProcessedDate(request.lastProcessedDate);
        newEntity.setNotes(request.notes);
        ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(newEntity);

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ScheduledRecurrentPaymentResponse update(MozidoTrxRequest mozidoTrxRequest, long id, ScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment updatedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));
        updatedEntity.setTenantName(request.tenantName);
        updatedEntity.setUserId(request.userId);
        updatedEntity.setAmount(request.amount);
        updatedEntity.setStartDate(request.startDate);
        updatedEntity.setEndDate(request.endDate);
        updatedEntity.setEndAfter(request.endAfter);
        updatedEntity.setType(request.type);
        updatedEntity.setFrequency(request.frequency);
        updatedEntity.setStatus(request.status);
        updatedEntity.setCancelUserId(request.cancelUserId);
        updatedEntity.setCancelDateTime(request.cancelDateTime);
        updatedEntity.setUserAccepted(request.userAccepted);
        updatedEntity.setUserDecline(request.userDecline);
        updatedEntity.setUserSuppressReminders(request.userSuppressReminders);
        updatedEntity.setPendingSenderApproval(request.pendingSenderApproval);
        updatedEntity.setLastProcessedDate(request.lastProcessedDate);
        updatedEntity.setNotes(request.notes);
        ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(updatedEntity);

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ScheduledRecurrentPaymentResponse get(MozidoTrxRequest mozidoTrxRequest, long id) {
        ScheduledRecurrentPayment savedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));
        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        response.setId(savedEntity.getId());
        response.setTenantName(savedEntity.getTenantName());
        response.setUserId(savedEntity.getUserId());
        response.setAmount(savedEntity.getAmount());
        response.setStartDate(savedEntity.getStartDate());
        response.setEndDate(savedEntity.getEndDate());
        response.setEndAfter(savedEntity.getEndAfter());
        response.setType(savedEntity.getType());
        response.setFrequency(savedEntity.getFrequency());
        response.setStatus(savedEntity.getStatus());
        response.setCancelUserId(savedEntity.getCancelUserId());
        response.setCancelDateTime(savedEntity.getCancelDateTime());
        response.setUserAccepted(savedEntity.isUserAccepted());
        response.setUserDecline(savedEntity.isUserDecline());
        response.setUserSuppressReminders(savedEntity.isUserSuppressReminders());
        response.setPendingSenderApproval(savedEntity.isPendingSenderApproval());
        response.setLastProcessedDate(savedEntity.getLastProcessedDate());
        response.setNotes(savedEntity.getNotes());
        return response;
    }

    public Page<ScheduledRecurrentPayment> findByFilters(ScheduledRecurrentPaymentFilter filter, Pageable pageable) {
        return scheduledRecurrentPaymentFilterRepository.findByFilters(filter, pageable);
    }



    public void processDuePayments(LocalDate today) {
        List<ScheduledRecurrentPayment> payments = scheduledRecurrentPaymentJpaRepository.findByStatus(PaymentStatus.ACTIVE);

        for (ScheduledRecurrentPayment p : payments)
        {
            if (paymentToProcess(p, today)) {
                try {
                    simulatePayment(p); // Simula pago (puede lanzar excepción)
                    p.setLastProcessedDate(today);
                } catch (Exception e) {
                    handlePaymentFailure(p, e.getMessage());
                }
                scheduledRecurrentPaymentJpaRepository.save(p);
            }
        }
    }

    private boolean paymentToProcess(ScheduledRecurrentPayment p, LocalDate today) {
        
        LocalDate last = p.getLastProcessedDate() == null ? p.getStartDate().minusDays(1) : p.getLastProcessedDate();

        if (p.getType() == PaymentType.SCHEDULED) {
            return today.equals(p.getStartDate());
        }


        long days = ChronoUnit.DAYS.between(last, today);
        return switch (p.getFrequency()) {
            case WEEKLY -> days >= 7;
            case BIWEEKLY -> days >= 14;
            case MONTHLY -> last.plusMonths(1).isBefore(today) || last.plusMonths(1).isEqual(today);
            case YEARLY -> last.plusYears(1).isBefore(today) || last.plusYears(1).isEqual(today);
        };

    }

    private void simulatePayment(ScheduledRecurrentPayment p) throws Exception {
        // Simulación con fallo aleatorio
        if (Math.random() < 0.3) {
            throw new Exception("Transacción rechazada por el banco.");
        }
        System.out.printf("✅ Pago procesado: %s %.2f\n", p.getUserId(), p.getAmount());
    }

    private void handlePaymentFailure(ScheduledRecurrentPayment p, String msg) {

        p.setLastProcessedDate(LocalDate.now());
        // TODO Add more Logic
    }

    private void notifyFailure(ScheduledRecurrentPayment p) {

    }
}
