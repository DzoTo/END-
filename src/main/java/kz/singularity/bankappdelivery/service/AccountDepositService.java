package kz.singularity.bankappdelivery.service;



import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);

    void add(Transaction transaction);
}
