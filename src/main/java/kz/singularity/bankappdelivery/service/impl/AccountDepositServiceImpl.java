package kz.singularity.bankappdelivery.service.impl;



import kz.singularity.bankappdelivery.Repository.AccountRepository;
import kz.singularity.bankappdelivery.Repository.TransactionRepository;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.transaction.Transaction;
import kz.singularity.bankappdelivery.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    AccountRepository accountRepository;

    TransactionRepository transactionRepository;

    public Iterable<Transaction> findAllTransactions(){
        return transactionRepository.findAll();
    }
    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        System.out.printf("%f are transferred to %s account\n", amount,
                String.format("%03d%06d%s", 1, 0, account.getId()));

    }

    @Override
    public void add(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
