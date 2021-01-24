package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.function.Predicate;

@Getter
public class Balance {
    private BigDecimal amount;
    private Currency currency;

    public Balance (Currency currency) {
        amount = BigDecimal.valueOf(1000); // initial amount
        this.currency = currency;
    }

    public boolean checkIfHaveEnoughRoubles (Predicate<BigDecimal> predicate) {
        if (currency.getCode() == Currency.RUR.getCode()) { // только рубль
            return predicate.test(amount);
        }
        return false;
    }

}
