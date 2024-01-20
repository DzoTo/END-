package kz.singularity.bankappdelivery.service;



import kz.singularity.bankappdelivery.model.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public class BankCore{
    static long id = 1;
    long lastAccountNumber = 1;


    AccountCreationService accountCreation;


    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientID){
    accountCreation.create(accountType,id, clientID, lastAccountNumber);
    incrementLastAccountNumber();
    }
    private void incrementLastAccountNumber(){
        lastAccountNumber++;
    }
}
