package com.financeiro.moneyflow.core.exception;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;

public record ApiError(
        String titile,
        int status,
        String detail,
        String instance,
        OffsetDateTime timestamp,
        Object message) {
            
    public static ApiError from(MethodArgumentNotValidException e, HttpServletRequest request) {
        var erros = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())));

        var titile = e.getBody().getTitle();
        var status = e.getBody().getStatus();
        var detail = e.getBody().getDetail();
        var instance = request.getRequestURI();
        var timestamp = OffsetDateTime.now();
        var message = Map.copyOf(erros);

        return new ApiError(titile, status, detail, instance, timestamp, message);
    }
}
