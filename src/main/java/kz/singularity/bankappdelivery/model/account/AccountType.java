package kz.singularity.bankappdelivery.model.account;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AccountType {
    CHECKING("CHECKING"),
    SAVING("SAVING"),
    FIXED("FIXED");

    private String type;

//    AccountTypeEnum(String type) {
//        this.type = type;
//    }


    public String getType() {
        return type;
    }
}

