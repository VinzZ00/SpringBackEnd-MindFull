package com.minidfull.backend.controller.exceptionController;

import com.minidfull.backend.dto.WebResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

//@RestControllerAdvice // Using rest Controller dont need to extend to ResponseEntity
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<WebResponse<String>> checkWhatExceptionIsCalled(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(WebResponse.<String>builder()
                        .err("error Exception with " + e.getMessage())
                        .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<WebResponse<String>> constraintViolationException(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(WebResponse.<String>builder()
                        .err(e.getMessage())
                        .build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<WebResponse<String>> APIViolationExceptoin(ResponseStatusException e) {
        return ResponseEntity
                .status(e.getStatusCode())
                .body(WebResponse.<String>builder()
                        .err(e.getReason())
                        .build());
    }
}
