package kz.singularity.bankappdelivery.service;


import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    Account getClientAccount(String clientID, Long accountID);

    Account getClientWithdrawAccount(String clientID, Long accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getCLientAccountsByType(String clientID, AccountType accountType);
}
