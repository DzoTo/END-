package kz.singularity.bankappdelivery.model.transaction;


import kz.singularity.bankappdelivery.model.WithdrawDepositOperationCLIUI;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionDepositCLI {

    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;

    AccountListingService accountListing;

    public void depositMoney(String clientID){
        System.out.println("Type account ID");
        Long id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        System.out.println("Type Amount of money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Account account = accountListing.getClientAccount(clientID, id);
//        AccountDeposit accountDeposit = new AccountDeposit(account.getAccountType(), account.getId(), account.getClientID(),
//                account.getBalance(), account.isWithdrawAllowed());
        transactionDeposit.execute(account, amount);
    }
}
