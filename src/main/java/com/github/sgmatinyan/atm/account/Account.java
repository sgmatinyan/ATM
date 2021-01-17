package com.github.sgmatinyan.atm.account;

import com.github.sgmatinyan.atm.Balance;
import lombok.Getter;

import java.util.Currency;
import java.util.Random;

@Getter
public abstract class Account {
    private Balance balance;

    public Account (Currency currency) {
        balance = new Balance(currency);
    }
}
