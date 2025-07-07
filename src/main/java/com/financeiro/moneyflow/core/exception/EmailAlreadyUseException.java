package com.financeiro.moneyflow.core.exception;

public class EmailAlreadyUseException extends RuntimeException{
    public EmailAlreadyUseException(String massage) {
        super(massage);
    }
}
