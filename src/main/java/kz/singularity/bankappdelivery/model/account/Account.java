package kz.singularity.bankappdelivery.model.account;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientID;
    private double balance;
    boolean withdrawAllowed;


    @Override
    public String toString() {
        String accountNumber = String.format("%03d%06d%s", 1, 0, id);

        return "Account{" +
                "accountType=" + accountType +
                ", id='" + accountNumber + '\'' +
                ", clientID='" + clientID + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }

}
