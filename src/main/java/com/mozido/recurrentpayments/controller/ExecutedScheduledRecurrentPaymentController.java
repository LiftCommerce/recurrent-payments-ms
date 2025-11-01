package com.mozido.recurrentpayments.controller;

import com.mozido.recurrentpayments.bussines.ExecutedScheduledRecurrentPaymentBs;
import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.PaymentTransactionStatus;
import com.mozido.recurrentpayments.model.request.ExecutedScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.response.ExecutedScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.Filters.ExecutedScheduledRecurrentPaymentFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/executed-scheduled-recurrent-payments")
@Tag(name ="ExecutedScheduledRecurrentPayment Controller")
public class ExecutedScheduledRecurrentPaymentController {


    private ExecutedScheduledRecurrentPaymentBs executedScheduledRecurrentPaymentBs;

    @Autowired
    public ExecutedScheduledRecurrentPaymentController (ExecutedScheduledRecurrentPaymentBs executedScheduledRecurrentPaymentBs)
    {
        this.executedScheduledRecurrentPaymentBs = executedScheduledRecurrentPaymentBs;
    }

    @PostMapping
    public ResponseEntity<ExecutedScheduledRecurrentPaymentResponse> create(@RequestBody ExecutedScheduledRecurrentPaymentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(executedScheduledRecurrentPaymentBs.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExecutedScheduledRecurrentPaymentResponse> update(@PathVariable long id,
                                                                            @RequestBody ExecutedScheduledRecurrentPaymentRequest request) {
        return ResponseEntity.ok(executedScheduledRecurrentPaymentBs.update(id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary ="Get a Executed Scheduled Recurrent Payment")
    public ResponseEntity<ExecutedScheduledRecurrentPaymentResponse> get(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @Parameter(description = "Id") @PathVariable long id)
    {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return ResponseEntity.ok(executedScheduledRecurrentPaymentBs.get(mozidoTrxRequest, id));
    }

    @GetMapping
    public Page<ExecutedScheduledRecurrentPayment> findByFilters(
            @RequestParam(required = false) Long scheduledRecurrentPaymentId,
            @RequestParam(required = false) LocalDate executionDate,
            @RequestParam(required = false) Boolean success,
            @RequestParam(required = false) Integer retries,
            @RequestParam(required = false) PaymentTransactionStatus transactionStatus,
            Pageable pageable
    ) {
        ExecutedScheduledRecurrentPaymentFilter filter = new ExecutedScheduledRecurrentPaymentFilter();
        filter.setScheduledRecurrentPaymentId(scheduledRecurrentPaymentId);
        filter.setExecutionDate(executionDate);
        filter.setSuccess(success);
        filter.setRetries(retries);
        filter.setTransactionStatus(transactionStatus);

        return executedScheduledRecurrentPaymentBs.getByFilters(filter, pageable);
    }
}
