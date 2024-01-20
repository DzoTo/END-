package kz.singularity.bankappdelivery.model.account;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
//@Table(name = "saving_accounts")
public class SavingAccount extends AccountWithdraw {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name = "SAVING";
    public SavingAccount(AccountType accountType, Long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }

    public SavingAccount() {
        super();
    }
}
