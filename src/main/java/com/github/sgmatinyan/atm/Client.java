package com.github.sgmatinyan.atm;

import java.math.BigDecimal;
import java.util.Currency;

public class Client {

    private String firstName, lastName;
    private Card[] cards; // not a collection yet

    public Client(String firstName, String lastName, int numOfCards) {
        this.firstName = firstName;
        this.lastName = lastName;
        cards = new Card[numOfCards];

        for (int i = 0; i < numOfCards; i++) {
            cards[i] = new Card(firstName, lastName, new Account(Currency.getInstance("RUR"))); // все счета пока что в рублях
        }
    }

    public String transferMoney(Card cardFrom, Account transferTo, BigDecimal sum) {
        ATM atm  = new ATM();
        return atm.transferMoney(cardFrom, cardFrom.getPIN(), transferTo, sum);
    }


    public Card getCard(int cardIndex) throws ArrayIndexOutOfBoundsException {
        return cards[cardIndex];
    }
}
