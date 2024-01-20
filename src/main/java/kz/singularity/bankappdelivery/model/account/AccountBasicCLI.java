package kz.singularity.bankappdelivery.model.account;



import kz.singularity.bankappdelivery.model.CreateAccountOperationUI;
import kz.singularity.bankappdelivery.service.AccountListingService;
import kz.singularity.bankappdelivery.service.BankCore;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI {

    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListing;


    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }
    public void createAccountRequest(AccountType accountType, String clientID) {
        bankCore.createNewAccount(accountType,clientID);
    }

    public void getAccounts(String clientID){
        System.out.println(accountListing.getClientAccounts(clientID));
    }
}
