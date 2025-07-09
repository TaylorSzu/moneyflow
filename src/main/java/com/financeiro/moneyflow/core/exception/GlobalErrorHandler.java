package com.financeiro.moneyflow.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handlerException(HttpServletRequest request, MethodArgumentNotValidException e) {
        return ResponseEntity
                .badRequest()
                .body(ApiError.from(e, request));
    } 
}
