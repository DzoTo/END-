package kz.singularity.bankappdelivery.controller;

import kz.singularity.bankappdelivery.dto.AccountTypeId;
import kz.singularity.bankappdelivery.model.account.Account;
import kz.singularity.bankappdelivery.model.account.AccountBasicCLI;
import kz.singularity.bankappdelivery.model.account.AccountType;
import kz.singularity.bankappdelivery.model.transaction.Transaction;
import kz.singularity.bankappdelivery.model.transaction.TransactionType;
import kz.singularity.bankappdelivery.service.impl.AccountCreationServiceImpl;
import kz.singularity.bankappdelivery.service.impl.AccountDepositServiceImpl;
import kz.singularity.bankappdelivery.service.impl.AccountListingServiceImpl;
import kz.singularity.bankappdelivery.service.impl.AccountWithdrawServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acc")
@Getter
@Setter
@RequiredArgsConstructor
public class AccountController {
    private final AccountListingServiceImpl accountListingServiceImpl;
    private final AccountCreationServiceImpl accountCreationServiceImpl;
    private final AccountBasicCLI accountBasicCLI;
    private final AccountWithdrawServiceImpl accountWithdrawServiceImpl;
    private final AccountDepositServiceImpl accountDepositServiceImpl;


    @GetMapping("/accounts")
    public List<Account> findAllAccounts(){
        return accountListingServiceImpl.getAllAccounts();
    }

    @GetMapping("/accounts/{account_id}")
    public Account getAccountById(@PathVariable("account_id") Long id){
        return accountListingServiceImpl.getAccountById(id);
    }

    @DeleteMapping("/accounts/{account_id}")
    public void deleteAccountByID(@PathVariable("account_id") Long id){
        accountListingServiceImpl.deleteAccount(id);
    }
    @PostMapping("/accounts")
    public void createAccount(@RequestBody AccountTypeId dto){
        accountBasicCLI.createAccountRequest(dto.getAccountType(), dto.getClientID());
    }

    @PostMapping("/accounts/{account_id}/withdraw")
    public void withdrowMoneyFromAccount(@PathVariable("account_id") Long id,
                                         @RequestParam double amount){
        Account account = accountListingServiceImpl.getAccountById(id);
        accountWithdrawServiceImpl.withdraw(amount, account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.WITHDRAW);
        accountDepositServiceImpl.add(transaction);
    }

    @PostMapping("/accounts/{account_id}/deposit")
    public void depositMoneyToAccount(@PathVariable("account_id") Long id,
                                         @RequestParam double amount){
        Account account = accountListingServiceImpl.getAccountById(id);
        accountDepositServiceImpl.deposit(amount, account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEPOSIT);
        accountDepositServiceImpl.add(transaction);
    }

    @GetMapping("/accounts/{account_id}/transactions")
    public Iterable<Transaction> getAllTransactions(@PathVariable("account_id") Long id){
        return accountDepositServiceImpl.findAllTransactions();
    }
}
