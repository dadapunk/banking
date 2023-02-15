package com.dada.banking_project.services;

import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountHolderService  {
    @Autowired
    AccountHolderRepository accountHolderRepository;

    public AccountHolder addAccountHolder(AccountHolder accountHolder){
        if (accountHolder.getName() == null || accountHolder.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account Holder name is required");
        }
        return accountHolderRepository.save(accountHolder);
    }

    public List<AccountHolder> findAllAccountHolder() {
        return accountHolderRepository.findAll();
    }
}
