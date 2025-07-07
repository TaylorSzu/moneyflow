package com.financeiro.moneyflow.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExistsIsNumberAccountException extends ResponseStatusException {
    public ExistsIsNumberAccountException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
