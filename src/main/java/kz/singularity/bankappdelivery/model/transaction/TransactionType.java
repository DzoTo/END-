package kz.singularity.bankappdelivery.model.transaction;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum TransactionType {
    DEPOSIT(3),
    WITHDRAW(4);
    private int type;
    TransactionType(int type){
        this.type = type;
    }
}
