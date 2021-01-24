package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.account.DepositAccount;
import com.github.sgmatinyan.atm.atm.ATM;
import com.github.sgmatinyan.atm.atm.IncorrectPINException;
import com.github.sgmatinyan.atm.atm.NotEnoughMoneyException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@PropertySource("classpath:application.properties")
@Component
public class Client {
    private String firstName, lastName;
    private List<Card> cards = new ArrayList<Card>(); // нормально же здесь не конкретизировать тип аккаунта для карт (дженерик)

    public Client(@Value("${client.firstname}") String firstName, @Value("${client.lastname}") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        cards.add(new Card<DepositAccount>(firstName,lastName,new DepositAccount(Currency.RUR))); // клиент создается с одной дефолтной рублевой картой
        cards.get(0).setDefault(true);
    }

    public void transferMoney(String transferTo, BigDecimal sum, ATM atm) throws NoDefaultCardException, NotEnoughMoneyException, IncorrectPINException {
        try {
            atm.transferMoney(getDefaultCard(), getDefaultCard().getPIN(), transferTo, sum);
        } catch (IncorrectPINException e) {
            log.error("Unexpected IncorrectPINException thrown for client " + firstName + " " + lastName);
            throw e;
        }
    }

    public Card getDefaultCard() throws NoDefaultCardException { // и здесь тоже Card используется без уточнения типа аккаунта (дженерик). Логично же в таких местах так и делать?
        for (Card card : cards) {
            if (card.isDefault()) {
                return card;
            }
        }
        throw new NoDefaultCardException();
    }
}
