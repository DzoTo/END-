package kz.singularity.bankappdelivery.service.impl;




import kz.singularity.bankappdelivery.Repository.AccountRepository;
import kz.singularity.bankappdelivery.model.account.AccountType;
import kz.singularity.bankappdelivery.model.account.CheckingAccount;
import kz.singularity.bankappdelivery.model.account.FixedAccount;
import kz.singularity.bankappdelivery.model.account.SavingAccount;
import kz.singularity.bankappdelivery.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
    @Autowired
    AccountRepository accountRepository;

    public AccountCreationServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void create(AccountType accountType, long bankID, String clientID, Long accountID) {
        switch (accountType) {
            case CHECKING -> accountRepository.save(new CheckingAccount(accountType, accountID, clientID, 0.0, true ));
            case SAVING -> accountRepository.save(new SavingAccount(accountType, accountID, clientID, 0.0, true ));
            case FIXED -> accountRepository.save(new FixedAccount(accountType, accountID, clientID, 0.0, false ));
            default -> System.out.println("Input is incorrect!");
        }
    }
}
