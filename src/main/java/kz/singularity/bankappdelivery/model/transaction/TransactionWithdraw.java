package kz.singularity.bankappdelivery.model.transaction;

import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransactionWithdraw {
    @Autowired
    AccountWithdrawService accountWithdrawService;


    public void execute(Account account, double amount){
        accountWithdrawService.withdraw(amount, account);
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.WITHDRAW);
        accountWithdrawService.add(transaction);
    }
}
