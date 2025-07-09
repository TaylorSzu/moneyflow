package com.financeiro.moneyflow.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateTransactionDTO(
        @NotBlank(message = "this id not null")
        Long id,
        @NotBlank(message = "this description not null")
        String description,
        @NotBlank(message = "this value not null")
        BigDecimal value,
        @NotBlank(message = "this type not null")
        String type,
        @NotBlank(message = "this date not null")
        LocalDate date,
        @NotBlank(message = "this account id not null")
        Long accountId
) {
}
