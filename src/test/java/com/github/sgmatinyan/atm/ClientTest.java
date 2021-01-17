package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.atm.ATM;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client = new Client("No", "Matter");

    @Test
    void transferMoney() throws Exception {
        assertEquals("Transfer succeed",client.transferMoney("+79998764525", BigDecimal.valueOf(1000), new ATM()));
    }
}