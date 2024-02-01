package kz.singularity.bankappdelivery.service.impl;


import kz.singularity.bankappdelivery.Repository.AccountRepository;
import kz.singularity.bankappdelivery.Repository.TransactionRepository;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountType;
import kz.singularity.bankappdelivery.model.account.AccountWithdraw;
import kz.singularity.bankappdelivery.model.transaction.Transaction;
import kz.singularity.bankappdelivery.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountRepository accountRepository;

    TransactionRepository transactionRepository;
    @Override
    public void withdraw(double amount, Account account) {
        if((account.getAccountType() != AccountType.FIXED)) {
            if (account.getBalance() - amount >= 0) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
                System.out.printf("%f are transferred from %s account\n", amount,
                        String.format("%03d%06d%s", 1, 0, account.getId()));
            } else {
                System.out.println("This account does not have enough money for withdraw");
            }
        }
        else {
            System.out.println("You can not withdraw money from FIXED account!");
        }
    }

    @Override
    public void add(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
