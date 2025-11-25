package com.mozido.recurrentpayments.exception;

import com.mozido.recurrentpayments.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse<Object>> handleStatusException(ResponseStatusException ex) {

        ApiResponse<Object> response = ApiResponse.error(
                ex.getStatusCode().value(),
                ex.getReason()
        );

        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }
}
