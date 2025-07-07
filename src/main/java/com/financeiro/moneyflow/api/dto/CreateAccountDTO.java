package com.financeiro.moneyflow.api.dto;

import java.math.BigDecimal;

public record CreateAccountDTO(
    String name,
    String institution,
    BigDecimal currentBalance,
    Long userId
) {

}
