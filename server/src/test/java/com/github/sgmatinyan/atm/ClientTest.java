package com.github.sgmatinyan.atm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client = new Client();

    @Test
    void checkIfDefaultCardInRUR() throws NoDefaultCardException {
        assertEquals(client.getDefaultCard().getCurrency(), Currency.RUR);
    }
}