package com.financeiro.moneyflow.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotEditEmailException extends ResponseStatusException{

    public NotEditEmailException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
