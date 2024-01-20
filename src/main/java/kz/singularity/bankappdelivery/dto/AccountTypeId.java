package kz.singularity.bankappdelivery.dto;

import kz.singularity.bankappdelivery.model.account.AccountType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@RequiredArgsConstructor
public class AccountTypeId {
    private String accountType;
    private String clientID;
}
