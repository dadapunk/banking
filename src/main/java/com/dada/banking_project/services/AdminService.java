package com.dada.banking_project.services;

import com.dada.banking_project.models.*;
import com.dada.banking_project.models.DTO.AccountDTO;
import com.dada.banking_project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;


@Service
public class AdminService {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    SavingAccountRepository savingAccountRepository;
    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    CreditCardAccountRepository creditCardAccountRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    public Account addAccount(AccountDTO accountDTO) {
        //Validate AccountHolder
        AccountHolder accountholder = accountHolderRepository.findById(accountDTO.getAccounHolderId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account Holder does not exist"));
        //Filter by Account type
        switch (accountDTO.getAccountType()) {
            case "SAVING":
                SavingAccount savingAccount = new SavingAccount(accountDTO.getBalance(),
                        accountDTO.getPrimaryOwner(), accountDTO.getSecondaryOwner(), accountDTO.getStatus(), accountholder);
                savingAccountRepository.save(savingAccount);
                break;
            case "CHECKING":
                if (accountholder.getAge() < 24) {
                    StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(accountDTO.getBalance(), accountDTO.getPrimaryOwner(),
                            accountDTO.getSecondaryOwner(), accountDTO.getStatus(), accountholder);
                studentCheckingAccountRepository.save(studentCheckingAccount);
                } else {
                    CheckingAccount checkingAccount = new CheckingAccount(accountDTO.getBalance(), accountDTO.getPrimaryOwner(),
                            accountDTO.getSecondaryOwner(), accountDTO.getStatus(), accountholder);
                checkingAccountRepository.save(checkingAccount);
                }
                break;
            case "CREDIT_CARD":
                CreditCardAccount creditCardAccount = new CreditCardAccount();
                creditCardAccountRepository.save(creditCardAccount);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type: " + accountDTO.getAccountType());

        }
        return null;
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public BigDecimal getAccountBalance(Integer accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        return account.getBalance();
    }

    public Account updateAccountBalance(Integer accountId, BigDecimal newBalance) {
        Account account = accountRepository.findById(accountId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account does not exist"));

        account.setBalance(newBalance);
        accountRepository.save(account);

        return account;
    }

}
