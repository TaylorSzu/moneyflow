package com.financeiro.moneyflow.core.exception;

import java.time.OffsetDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public record ApiError(
    String type,
    String titile,
    int status,
    String detail,
    String instance,
    OffsetDateTime timestamp,
    Object message
) {
    public static ApiError from (MethodArgumentNotValidException e, HttpServletRequest request) {
        //estou tentando entender como fazer, por que eu não peguei a explicação do papai
        return null;
   }
}
