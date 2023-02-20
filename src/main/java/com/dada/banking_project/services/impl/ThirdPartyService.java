package com.dada.banking_project.services.impl;

import com.dada.banking_project.dtos.ThirdPartyTransactionDTO;
import com.dada.banking_project.dtos.TransactionResponseDTO;
import com.dada.banking_project.models.Accounts.CheckingAccount;
import com.dada.banking_project.models.Users.ThirdParty;
import com.dada.banking_project.models.Transaction;
import com.dada.banking_project.repositories.CheckingAccountRepository;
import com.dada.banking_project.repositories.ThirdPartyRepository;
import com.dada.banking_project.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Service
public class ThirdPartyService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionResponseDTO createTransaction(ThirdPartyTransactionDTO thirdPartyTransactionDTO) {
        CheckingAccount accountSender = checkingAccountRepository.findById(
                thirdPartyTransactionDTO.getIdAccountSender().intValue()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Sender Doesn´t Exist")
        );
        CheckingAccount accountReciever = checkingAccountRepository.findById(
                thirdPartyTransactionDTO.getIdAccountReciever().intValue()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Reciever Doesn´t Exist")
        );
        ThirdParty thirdParty = thirdPartyRepository.findByHashedKey(thirdPartyTransactionDTO.getHashedKey());
        if (thirdParty == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Third Party Not Found");

        if (accountSender.getBalance().compareTo(BigDecimal.valueOf(thirdPartyTransactionDTO.getAmount())) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient founds");
        }

        Transaction transaction = new Transaction();

        transaction.setSender(accountSender);
        transaction.setReceiver(accountReciever);
        transaction.setAmount((BigDecimal.valueOf(thirdPartyTransactionDTO.getAmount())));
        transaction.setDate(LocalDateTime.now());

        accountSender.setBalance((accountSender.getBalance().subtract(BigDecimal.valueOf(thirdPartyTransactionDTO.getAmount()))));
        accountReciever.setBalance((accountReciever.getBalance().add(BigDecimal.valueOf(thirdPartyTransactionDTO.getAmount()))));

        transactionRepository.save(transaction);
        checkingAccountRepository.save(accountReciever);
        checkingAccountRepository.save(accountSender);

        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
        transactionResponseDTO.setOldAmount(accountSender.getBalance().intValue());
        transactionResponseDTO.setUsername(accountSender.getPrimaryOwner());
        transactionResponseDTO.setNewAmount(accountSender.getBalance().intValue());
        return transactionResponseDTO;

    }
}
