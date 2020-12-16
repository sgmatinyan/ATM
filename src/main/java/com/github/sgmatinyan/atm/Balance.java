package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
public class Balance {
    private BigDecimal amount;
    private Currency currency;

    public Balance (Currency currency) {
        amount = BigDecimal.valueOf(1000); // initialamount
        this.currency = currency;
    }

    public void changeAmount(BigDecimal sum) {
        amount = amount.add(sum);
    }
}
