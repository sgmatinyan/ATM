package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.util.Currency;
import java.util.Random;

public class Account {
    private String num;
    @Getter
    private Balance balance;

    public Account (Currency currency) {
        Random random = new Random();
        num = random.nextInt(999999999) + ""; // simplified
        balance = new Balance(currency);
    }
}
