package kz.singularity.bankappdelivery.service.impl;



import kz.singularity.bankappdelivery.Repository.AccountRepository;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountType;
import kz.singularity.bankappdelivery.service.AccountListingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {

    AccountRepository accountRepository;

    public AccountListingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        return accountRepository.getAccountById(id);
    }

    public void deleteAccount(Long id){
        boolean exist =accountRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("account with id: " + id + "doesn't exist");
        }
        accountRepository.deleteById(id);
    }
    @Override
    public Account getClientAccount(String clientID, Long accountID) {
       return accountRepository.getAccountByClientIDAndId(clientID, accountID);
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, Long accountID) {
        return accountRepository.getAccountByClientIDAndId(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountRepository.getAccountsByClientID(clientID);
    }

    @Override
    public List<Account> getCLientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.getAccountsByClientIDAndAccountType(clientID,accountType);
    }
}
