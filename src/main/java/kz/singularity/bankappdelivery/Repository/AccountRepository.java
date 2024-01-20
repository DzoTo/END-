package kz.singularity.bankappdelivery.Repository;




import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByClientIDAndId(String clientID, Long id);

    Account getAccountById(Long id);

    List<Account> getAccountsByClientID(String clientID);


    List<Account> getAccountsByClientIDAndAccountType(String clientID, AccountType accountType);

//    @Query("INSERT INTO Account values (account)")
//    void addTransaction(Account account);
}
