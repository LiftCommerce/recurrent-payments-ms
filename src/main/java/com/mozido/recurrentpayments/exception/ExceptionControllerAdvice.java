package com.mozido.recurrentpayments.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rafael Richards on 06/25.
 */

@ControllerAdvice
public class ExceptionControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({ControllerException.class})
    @ResponseBody
    private ErrorResponse exceptionHandler(ControllerException ce, HttpServletResponse response) {
        getMessage(ce);
        logger.error(ce.getMessage());
        logger.error("Controller Exception detected", ce);
        response.setStatus(ce.getErrorResponse().getStatus().value());
        return ce.getErrorResponse();
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    private ErrorResponse exceptionHandler(Exception ex, HttpServletResponse response, Integer code) {
        logger.error("Unhandled exception detected", ex);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, code, ex.getMessage());
    }

    private void getMessage(ControllerException ce) {
        if (null != ce.getErrorResponse().getLanguage()) {
            switch (ce.getErrorResponse().getLanguage()) {
                case ENGLISH:
                    ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
                    break;
                default:
                    ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
            }
        } else {
            ce.getErrorResponse().setMessage(ce.getErrorResponse().getMessages().get(0));
        }

    }

}