package kz.singularity.bankappdelivery.model.transaction;

import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.service.AccountDepositService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransactionDeposit {
    @Autowired
    AccountDepositService accountDepositService;

    public void execute(Account account, double amount){
        accountDepositService.deposit(amount, account);
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEPOSIT);
        accountDepositService.add(transaction);
    }
}
