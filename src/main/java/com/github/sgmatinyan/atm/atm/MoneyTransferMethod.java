package com.github.sgmatinyan.atm.atm;

import lombok.Getter;

@Getter
public enum MoneyTransferMethod {
    BY_PHONE_NUMBER ("Номер телефона (формат +7XXXXXXXXXX", "//+7\\d{10}"),
    BY_ACCOUNT_NUMBER("Номер счета", "[1-9]\\d{11}");

    private String description;
    private String pattern;

    MoneyTransferMethod (String description, String pattern) {
        this.description = description;
        this.pattern = pattern;
    }
    public boolean matchesPattern(String inp) {
        return inp.matches(pattern);
    }
}
