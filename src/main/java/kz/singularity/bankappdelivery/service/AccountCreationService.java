package kz.singularity.bankappdelivery.service;



import kz.singularity.bankappdelivery.model.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService{

    void create(AccountType accountType, long bankID,
                String clientID, Long accountID);
}
