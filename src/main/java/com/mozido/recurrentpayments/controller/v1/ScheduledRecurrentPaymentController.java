package com.mozido.recurrentpayments.controller.v1;

import com.mozido.recurrentpayments.bussines.ScheduledRecurrentPaymentBs;
import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.request.ScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ScheduledRecurrentPaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

@RestController
@RequestMapping("/api/scheduled-recurrent-payments")
@Tag(name ="ScheduledRecurrentPayment Controller")

public class ScheduledRecurrentPaymentController {

    private ScheduledRecurrentPaymentBs scheduledRecurrentPaymentBs;

    @Autowired
    public ScheduledRecurrentPaymentController(ScheduledRecurrentPaymentBs service) {
        this.scheduledRecurrentPaymentBs = service;
    }


    @PostMapping
    @Operation(summary ="Create a Scheduled Recurrent Payment")
    public ResponseEntity<ScheduledRecurrentPaymentResponse> create(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @RequestBody ScheduledRecurrentPaymentRequest request) throws ControllerException
    {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledRecurrentPaymentBs.create(mozidoTrxRequest, request));
    }

    @PutMapping("/{id}")
    @Operation(summary ="Update a Scheduled Recurrent Payment")
    public ResponseEntity<ScheduledRecurrentPaymentResponse> update(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @Parameter(description = "Id") @PathVariable long id,
            @RequestBody ScheduledRecurrentPaymentRequest request)  throws ControllerException
    {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return ResponseEntity.ok(scheduledRecurrentPaymentBs.update(mozidoTrxRequest, id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary ="Get a Scheduled Recurrent Payment")
    public ResponseEntity<ScheduledRecurrentPaymentResponse> get(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @Parameter(description = "Id") @PathVariable long id)
    {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return ResponseEntity.ok(scheduledRecurrentPaymentBs.get(mozidoTrxRequest, id));
    }

    @GetMapping
    public ResponseEntity<Page<ScheduledRecurrentPaymentResponse>> findByFilters(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) PaymentStatus status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(scheduledRecurrentPaymentBs.findByFilters(userId, status, startDate, endDate, pageable));
    }
}
