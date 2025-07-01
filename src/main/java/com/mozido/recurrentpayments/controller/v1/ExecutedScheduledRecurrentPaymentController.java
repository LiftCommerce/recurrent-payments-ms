package com.mozido.recurrentpayments.controller.v1;

import com.mozido.recurrentpayments.bussines.ExecutedScheduledRecurrentPaymentBs;
import com.mozido.recurrentpayments.model.request.ExecutedScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ExecutedScheduledRecurrentPaymentResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/executed-scheduled-recurrent-payments")
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
}
