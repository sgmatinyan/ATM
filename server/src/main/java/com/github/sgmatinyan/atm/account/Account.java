package com.github.sgmatinyan.atm.account;

import com.github.sgmatinyan.atm.Balance;
import com.github.sgmatinyan.atm.Currency;
import lombok.Getter;


@Getter
public abstract class Account {
    private Balance balance;

    public Account (Currency currency) {
        balance = new Balance(currency);
    }
}
