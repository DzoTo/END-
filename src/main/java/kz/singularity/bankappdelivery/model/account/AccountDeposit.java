package kz.singularity.bankappdelivery.model.account;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, Long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }

}
