package com.github.sgmatinyan.atm;

import com.github.sgmatinyan.atm.atm.ATM;
import com.github.sgmatinyan.atm.atm.IncorrectPINException;
import com.github.sgmatinyan.atm.atm.NotEnoughMoneyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.github.sgmatinyan.atm","com.github.sgmatinyan.atm.atm");

        Client client = context.getBean(Client.class);
        ATM atm = context.getBean(ATM.class);

        Scanner scanner = new Scanner(System.in);
        String transferTo;

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
            client.transferMoney(transferTo, BigDecimal.valueOf(1000), atm); // когда-нибудь клиент сможет сам выбирать сумму для перевода, или MVP в нашем понимании :)
        } catch (NotEnoughMoneyException e) {
            System.out.println("Недостаточно денег не счете");
        } catch (NoDefaultCardException e) {
            System.out.println("Не указана стандартная карта карты");
        } catch (IncorrectPINException e) {
            System.out.println("Некорректный ПИН");
            log.error("Некорректный ПИН");
        }
    }
}