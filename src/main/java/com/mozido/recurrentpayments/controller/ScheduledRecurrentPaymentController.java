package com.mozido.recurrentpayments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozido.recurrentpayments.bussines.ScheduledRecurrentPaymentBs;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.request.ScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ApiPaginatedResponse;
import com.mozido.recurrentpayments.model.response.ApiResponse;
import com.mozido.recurrentpayments.model.response.ScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.Filters.ScheduledRecurrentPaymentFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Rafael Richards on 06/25.
 */

@RestController
@RequestMapping("/scheduled-recurrent-payments")
@Tag(name ="ScheduledRecurrentPayment Controller")

public class ScheduledRecurrentPaymentController {

    private ScheduledRecurrentPaymentBs scheduledRecurrentPaymentBs;

    @Autowired
    public ScheduledRecurrentPaymentController(ScheduledRecurrentPaymentBs service) {
        this.scheduledRecurrentPaymentBs = service;
    }


    @PostMapping
    @Operation(summary ="Create a Scheduled Recurrent Payment")
    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> create(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @RequestBody ScheduledRecurrentPaymentRequest request) throws Exception {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return scheduledRecurrentPaymentBs.create(mozidoTrxRequest, request);
    }

    @PutMapping("/{id}")
    @Operation(summary ="Update a Scheduled Recurrent Payment")
    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> update(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @Parameter(description = "Id") @PathVariable long id,
            @RequestBody ScheduledRecurrentPaymentRequest request) throws ControllerException, ParseException, JsonProcessingException {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return scheduledRecurrentPaymentBs.update(mozidoTrxRequest, id, request);
    }

    @GetMapping("/{id}")
    @Operation(summary ="Get a Scheduled Recurrent Payment")
    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> get(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            @Parameter(description = "Id") @PathVariable long id) throws ControllerException, ParseException, JsonProcessingException {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        return scheduledRecurrentPaymentBs.get(mozidoTrxRequest, id);
    }

    @PostMapping("/search")
    @Operation(summary = "Get a Scheduled Recurrent Payments by Filters")
    public ResponseEntity<ApiPaginatedResponse<ScheduledRecurrentPayment>> findByFilters(
            @Parameter(description = "Tenant name, If you have your tenant use it, if not we provide one.") @RequestHeader(value = "tenantName") String tenantName,
            @Parameter(description = "Authorization token") @RequestHeader(value = "Authorization") String token,
            Pageable pageable,
            @RequestBody ScheduledRecurrentPaymentFilter filterRequest)
    {
        MozidoTrxRequest mozidoTrxRequest = new MozidoTrxRequest(tenantName, token, null);
        Page<ScheduledRecurrentPayment> page = scheduledRecurrentPaymentBs.findByFilters(mozidoTrxRequest, filterRequest, pageable);
        Map<String, Object> meta = Map.of(
                "page", page.getNumber(),
                "size", page.getSize(),
                "totalElements", page.getTotalElements(),
                "totalPages", page.getTotalPages(),
                "sort", pageable.getSort().toString()
        );

        return ResponseEntity.ok(ApiPaginatedResponse.ok(page.getContent(), meta));
    }

    private Pageable buildPageable(int page, int size, String[] sortParams) {
        List<Sort.Order> orders = new ArrayList<>();

        if (sortParams != null)
        {
            for (String param : sortParams)
            {
                String[] parts = param.split(",");
                String property = parts[0];
                Sort.Direction direction = Sort.Direction.ASC; // default value

                if (parts.length > 1) {
                    direction = Sort.Direction.fromString(parts[1]);
                }

                orders.add(new Sort.Order(direction, property));
            }
        }

        Sort sort = orders.isEmpty() ? Sort.unsorted() : Sort.by(orders);
        return PageRequest.of(page, size, sort);
    }
}
