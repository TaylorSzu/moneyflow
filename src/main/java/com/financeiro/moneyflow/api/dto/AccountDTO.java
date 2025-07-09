package com.financeiro.moneyflow.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record AccountDTO(
    @NotBlank(message = "this message not null")
    String name,
    @NotBlank(message = "this institution not null")
    String institution,
    @NotBlank(message = "this current balance not null")
    BigDecimal currentBalance,
    @NotBlank(message = "this user id not null")
    Long userId
) {

}
