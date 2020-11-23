package com.github.sgmatinyan.atm;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Random;

public class Card {
    private final static int NUM_OF_YEARS_VALID  = 4;
    @Getter
    private String number, dueDate, owner, CVV, PIN;
    @Getter
    private Account account;

    public Card(String firstName, String lastName, Account account) {
        Random random = new Random();

        owner = firstName.toUpperCase() + " " + lastName.toUpperCase();
        dueDate = generateDueDate();
        this.account = account;

        for (int i = 0; i < 16; i++) {
            number += random.nextInt(10);
        }
        for (int i = 0; i < 4; i++) {
            PIN += random.nextInt(10);
        }
        for (int i = 0; i < 3; i++) {
            CVV += random.nextInt(10);
        }

    }

    private String generateDueDate() {
        String result;
        LocalDate currentDate = LocalDate.now();

        result = currentDate.getMonth() + "/" + (currentDate.getYear() + Card.NUM_OF_YEARS_VALID);
        return result;
    }
}
