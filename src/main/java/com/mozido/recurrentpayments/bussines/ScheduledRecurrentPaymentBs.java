package com.mozido.recurrentpayments.bussines;

import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentType;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.request.ScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.ScheduledRecurrentPaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rafael Richards on 06/25.
 */

@Service
public class ScheduledRecurrentPaymentBs {


    private ScheduledRecurrentPaymentRepository scheduledRecurrentPaymentRepository;

    @Autowired
    public ScheduledRecurrentPaymentBs(ScheduledRecurrentPaymentRepository repository) {
        this.scheduledRecurrentPaymentRepository = repository;
    }

    public ScheduledRecurrentPaymentResponse create(MozidoTrxRequest mozidoTrxRequest, ScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment entity = new ScheduledRecurrentPayment();
        BeanUtils.copyProperties(request, entity);
        ScheduledRecurrentPayment saved = scheduledRecurrentPaymentRepository.save(entity);

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ScheduledRecurrentPaymentResponse update(MozidoTrxRequest mozidoTrxRequest, long id, ScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment entity = scheduledRecurrentPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));
        BeanUtils.copyProperties(request, entity);
        ScheduledRecurrentPayment saved = scheduledRecurrentPaymentRepository.save(entity);

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ScheduledRecurrentPaymentResponse get(MozidoTrxRequest mozidoTrxRequest, long id) {
        ScheduledRecurrentPayment entity = scheduledRecurrentPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));
        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    public Page<ScheduledRecurrentPaymentResponse> findByFilters(String userId, PaymentStatus status,
                                                                 LocalDate startDate, LocalDate endDate,
                                                                 Pageable pageable) {
        Page<ScheduledRecurrentPayment> results = scheduledRecurrentPaymentRepository.findByFilters(userId, status, startDate, endDate, pageable);
        return results.map(entity -> {
            ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
            BeanUtils.copyProperties(entity, response);
            return response;
        });
    }


    public void processDuePayments(LocalDate today) {
        List<ScheduledRecurrentPayment> payments = scheduledRecurrentPaymentRepository.findByStatus(PaymentStatus.ACTIVE);

        for (ScheduledRecurrentPayment p : payments)
        {
            if (paymentToProcess(p, today)) {
                try {
                    simulatePayment(p); // Simula pago (puede lanzar excepción)
                    p.setLastProcessedDate(today);
                } catch (Exception e) {
                    handlePaymentFailure(p, e.getMessage());
                }
                scheduledRecurrentPaymentRepository.save(p);
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
