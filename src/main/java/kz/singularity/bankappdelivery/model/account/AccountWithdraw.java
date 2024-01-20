package kz.singularity.bankappdelivery.model.account;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountWithdraw extends Account{
    public AccountWithdraw(AccountType accountType, Long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }


}
