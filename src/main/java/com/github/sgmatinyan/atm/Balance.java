package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.function.Predicate;

@Getter
public class Balance {
    private BigDecimal amount;
    private Currency currency;

    public Balance (Currency currency) {
        amount = BigDecimal.valueOf(1000); // initialamount
        this.currency = currency;
    }

    public boolean checkIfHaveEnoughRoubles (Predicate<BigDecimal> predicate) {
        if (currency.getCurrencyCode() == "RUR") {
            return predicate.test(amount);
        }
        return false;
    }

}
