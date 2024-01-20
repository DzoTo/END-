package kz.singularity.bankappdelivery.model.transaction;

import kz.singularity.bankappdelivery.model.WithdrawDepositOperationCLIUI;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountType;
import kz.singularity.bankappdelivery.model.account.AccountWithdraw;
import kz.singularity.bankappdelivery.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionWithdrawCLI {

    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void withdrawMoney(String clientID){
        System.out.println("Type account ID");
        Long id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        System.out.println("Type amount of Money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Account account = accountListing.getClientAccount(clientID, id);
        if(account.getAccountType() != AccountType.FIXED){
            AccountWithdraw accountWithdraw = new AccountWithdraw(account.getAccountType(), account.getId(), account.getClientID(),
                    account.getBalance(), account.isWithdrawAllowed());
            //AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, id);
            transactionWithdraw.execute(account, amount);
        }
        else{
            System.out.println("You can not withdraw money from FIXED account!");
        }
    }
}
