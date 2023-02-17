package com.dada.banking_project.services;

import com.dada.banking_project.models.Account;
import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.models.DTO.AccountHolderDTO;
import com.dada.banking_project.models.DTO.TransactionDTO;
import com.dada.banking_project.models.Transaction;
import com.dada.banking_project.repositories.AccountHolderRepository;
import com.dada.banking_project.repositories.AccountRepository;
import com.dada.banking_project.repositories.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountHolderService  {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public Transaction transaction(TransactionDTO transactionDTO) {
        Account sender = accountRepository.findById(transactionDTO.getSenderAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        Account receiver = accountRepository.findById(transactionDTO.getReceiverAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        if (!sender.checkBalance(transactionDTO.getAmount())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient balance");
        }
        if (!receiver.checkOwnerName(transactionDTO.getPrimaryOrSecondaryOwnersName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid owner name");
        }

        sender.setBalance(sender.getBalance().subtract(transactionDTO.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transactionDTO.getAmount()));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getTransactionDate());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);

        transactionRepository.save(transaction);

        return transaction;
    }

    public AccountHolder addAccountHolder(AccountHolder accountHolder){
        if (accountHolder.getName() == null || accountHolder.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account Holder name is required");
        }
        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> findAllAccountHolder() {
        return accountHolderRepository.findAll();
    }


    public List<Account> checkBalanceAccounts(Integer accountHolderId) {
        return accountRepository.findByAccountHolder_Id(accountHolderId);
    }
}
