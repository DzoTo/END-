package kz.singularity.bankappdelivery.model.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
//@Table(name = "checking_accounts")
public class CheckingAccount extends AccountWithdraw {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name = "CHECKING";

    public CheckingAccount(AccountType accountType, Long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }

    public CheckingAccount() {
        super();
    }
}
