package org.example.ticket_system.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandlerController {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(
            ApiException ex,
            WebRequest request
    ) {
        logger.warn("API Exception: {}", ex.getLocalizedMessage(), ex);
        return new ResponseEntity<>(ex, ex.getHttpStatus());
    }
}
