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

    /**
     * Performs a transaction between two accounts based on the information provided in the TransactionDTO.
     *
     * @param transactionDTO the information about the transaction, including sender account ID, receiver account ID, amount, primary or secondary owner name, and transaction date.
     * @return the transaction object that represents this transaction.
     * @throws EntityNotFoundException if either the sender or the receiver account is not found in the database.
     * @throws ResponseStatusException if the sender does not have enough balance or if the owner name of the receiver account is not valid.
     */
    public Transaction transaction(TransactionDTO transactionDTO) {
        // Find the sender account from the database based on the account ID provided in the transaction DTO.
        Account sender = accountRepository.findById(transactionDTO.getSenderAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        // Find the receiver account from the database based on the account ID provided in the transaction DTO.
        Account receiver = accountRepository.findById(transactionDTO.getReceiverAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));

        // Check if the sender has enough balance to perform the transaction.
        if (!sender.checkBalance(transactionDTO.getAmount())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient balance");
        }

        // Check if the primary or secondary owner name of the receiver account matches the name provided in the transaction DTO.
        if (!receiver.checkOwnerName(transactionDTO.getPrimaryOrSecondaryOwnersName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid owner name");
        }

        // Update the balance of the sender account and the receiver account based on the transaction amount.
        sender.setBalance(sender.getBalance().subtract(transactionDTO.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transactionDTO.getAmount()));

        // Save the updated sender account and receiver account to the database.
        accountRepository.save(sender);
        accountRepository.save(receiver);

        // Create a transaction object and set its properties based on the transaction DTO and the updated sender and receiver accounts.
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDate(transactionDTO.getTransactionDate());
        transaction.setSender(sender);
        transaction.setReceiver(receiver);

        // Save the transaction object to the database.
        transactionRepository.save(transaction);

        // Return the transaction object that represents this transaction.
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
