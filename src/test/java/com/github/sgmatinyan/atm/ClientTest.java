package com.github.sgmatinyan.atm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client = new Client("No", "Matter", 3);
    Account account = new Account(Currency.getInstance("RUR"));

    @Test
    void transferMoney() {
        assertEquals("No enough money",client.transferMoney(client.getCard(1),account, BigDecimal.valueOf(1000)));
    }
}