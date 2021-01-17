package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.atm.ATM;
import com.github.sgmatinyan.atm.atm.NotEnoughMoneyException;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String transferTo;

        Client client = new Client("Alex", "Filin");
        ATM atm = new ATM();


        System.out.println(atm.getGreeting(client));
        System.out.println(atm.getMoneyTransferOptions());
        System.out.println();
        System.out.println(atm.getRequisitesRequest());

        transferTo = scanner.nextLine();

        if (!atm.isTransferPossible(transferTo)) {
            System.out.println("Неправильные реквизиты!");
            return;
        }

        try {
            System.out.println(client.transferMoney(transferTo, BigDecimal.valueOf(1000), atm)); // когда-нибудь клиент сможет сам выбирать сумму для перевода, или MVP в нашем понимании :)
        } catch (NotEnoughMoneyException e) {
            System.out.println("Недостаточно денег не счете");
            log.error("Something went wrong. Guess what?");
        } catch (NoDefaultCardException e) {
            System.out.println("Не указана стандартная карта карты");
        }
    }
}