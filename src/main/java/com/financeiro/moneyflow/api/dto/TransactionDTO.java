package com.financeiro.moneyflow.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TransactionDTO(
        @NotBlank(message = "this description not null")
        String description,
        @NotBlank(message = "this value not null")
        BigDecimal value,
        @NotBlank(message = "this type not null")
        String type,
        @NotBlank(message = "this account id not null")
        Long accountId) {
}
