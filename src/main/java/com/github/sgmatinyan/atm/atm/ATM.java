package com.github.sgmatinyan.atm.atm;

import com.github.sgmatinyan.atm.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ATM {

    public String transferMoney(Card cardFrom, String PIN, String transferTo, BigDecimal sum) throws IncorrectPINException, NotEnoughMoneyException {
        if(!cardFrom.getPIN().equals(PIN)) {
            throw new IncorrectPINException();
        }
        if (cardFrom.getAccount().getBalance().getAmount().compareTo(sum) < 0) {
            throw new NotEnoughMoneyException();
        }
        // *осуществление перевода*
        return "Transfer succeed";
    }

    public String getGreeting(Client client) {
        return String.format("Здравствуйте, %s %s!", client.getFirstName(), client.getLastName());
    }
    public String getMoneyTransferOptions() {
        AtomicReference<String> returnValue = null;
        returnValue.set("Доступны следующие форматы переводов:\n");
        Arrays.asList(MoneyTransferMethod.values()).forEach(method -> returnValue.set(returnValue.get() + String.format("- %s\n", method.getDescription())));
        return returnValue.get();
    }

    public String getRequisitesRequest() {
        return "Укажите любые реквизиты получателя: ";
    }

    public boolean isTransferPossible(String transferTo) {
        Optional<MoneyTransferMethod> transferMethod = Optional.empty();
        for (MoneyTransferMethod method:MoneyTransferMethod.values()) {
            if (method.matchesPattern(transferTo)) {
                transferMethod = Optional.of(method);
                break;
            }
        }
        return transferMethod.isPresent();
    }

}
