package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.account.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
public class Card <T extends Account> {
    // некоторая обязательная информация о карте нигде в учебном проекте не используется
    private final static int NUM_OF_YEARS_VALID  = 4;
    private String number, dueDate, owner, CVV, PIN;
    private T account;
    @Setter
    private boolean isDefault;

    public Card(String firstName, String lastName, T account) {
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

    public Currency getCurrency() {
        return account.getBalance().getCurrency();
    }
}
