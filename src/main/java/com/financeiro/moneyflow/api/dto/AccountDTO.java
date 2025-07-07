package com.financeiro.moneyflow.api.dto;

import java.math.BigDecimal;

public record AccountDTO(
    String name,
    String institution,
    BigDecimal currentBalance,
    Long userId
) {

}
