package com.github.sgmatinyan.atm.account;

import java.math.BigDecimal;
import java.util.Currency;

// нигде не используется, создано для учебной работы с дженериками
public class CreditAccount extends Account {
    private BigDecimal availableLimit;

    public CreditAccount(Currency currency) {
        super(currency);
    }
}
