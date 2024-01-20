package kz.singularity.bankappdelivery.service;


import kz.singularity.bankappdelivery.model.CLIUI;
import kz.singularity.bankappdelivery.model.account.AccountType;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;
    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public AccountType requestAccountType() {
        return AccountType.valueOf(scanner.nextLine());
    }

    @Override
    public double requestClientAmount() {
        return scanner.nextDouble();
    }

    @Override
    public Long requestClientAccountNumber() {
        return scanner.nextLong();
    }
}
