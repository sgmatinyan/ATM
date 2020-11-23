package com.github.sgmatinyan.atm;

import java.math.BigDecimal;
import java.util.Currency;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Alex", "Filin", 3);
        Account accountTransferTo = new Account(Currency.getInstance("RUR"));

        try {
            client.transferMoney(client.getCard(1),accountTransferTo, BigDecimal.valueOf(1000));
        } catch (ArrayIndexOutOfBoundsException e) {
            // todo: добавить SLF4J логирование
        }
    }
}