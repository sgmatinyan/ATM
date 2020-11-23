package com.github.sgmatinyan.atm;

import java.math.BigDecimal;

public class ATM {

    public String transferMoney(Card cardFrom, String PIN, Account transferTo, BigDecimal sum) {
        if(!cardFrom.getPIN().equals(PIN)) {
            return "Incorrect PIN";
        } else if (cardFrom.getAccount().getBalance().getAmount().compareTo(sum) < 0) {
            return "No enough money";
        } else if (transferTo.getBalance().getCurrency().getCurrencyCode() != cardFrom.getAccount().getBalance().getCurrency().getCurrencyCode()) {
            return "Convertation is not supported";
        }
        transferTo.getBalance().changeAmount(sum);
        return "Transfer succeed";
    }

}
