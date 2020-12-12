package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;

public class Balance {
    @Getter
    private BigDecimal amount;
    @Getter
    private Currency currency;

    public Balance (Currency currency) {
        amount = BigDecimal.valueOf(0); // initial amount
        this.currency = currency;
    }

    public void changeAmount(BigDecimal sum) {
        amount = amount.add(sum);
    }
}
