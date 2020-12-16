package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.account.DepositAccount;
import com.github.sgmatinyan.atm.atm.ATM;
import com.github.sgmatinyan.atm.atm.IncorrectPINException;
import com.github.sgmatinyan.atm.atm.NotEnoughMoneyException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Getter
public class Client {
    private String firstName, lastName;
    private List<Card> cards = new ArrayList<Card>(); // нормально же здесь не конкретизировать тип аккаунта для карт (дженерик)

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        cards.add(new Card<DepositAccount>(firstName,lastName,new DepositAccount(Currency.getInstance("RUR")))); // клиент создается с одной дефолтной рублевой картой
        cards.get(0).setDefault(true);
    }

    public String transferMoney(String transferTo, BigDecimal sum, ATM atm) throws NoDefaultCardException, NotEnoughMoneyException {
        try {
            return atm.transferMoney(getDefaultCard(), getDefaultCard().getPIN(), transferTo, sum);
        } catch (NoDefaultCardException | NotEnoughMoneyException e) {
            throw e;
        } catch (IncorrectPINException e) {
            // todo: Something strange is happening here...
        }
        return "Error";
    }

    private Card getDefaultCard() throws NoDefaultCardException { // и здесь тоже Card используется без уточнения типа аккаунта (дженерик). Логично же в таких местах так и делать?
        for (Card card : cards) {
            if (card.isDefault()) {
                return card;
            }
        }
        throw new NoDefaultCardException();
    }
}
