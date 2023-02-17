package com.dada.banking_project.controllers;

import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.models.DTO.TransactionDTO;
import com.dada.banking_project.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/account-holder/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder)
    {
        return accountHolderService.addAccountHolder(accountHolder);
    }
    // Get all AccountHolders
    @GetMapping("/account-holder-all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAllAccountHolder(){
        return accountHolderService.findAllAccountHolder();
    }

    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.OK)
    public void transferFunds(@RequestBody TransactionDTO transactionDTO, Authentication authentication) {
        accountHolderService.transaction(transactionDTO);
        System.out.println(authentication.isAuthenticated());
    }




}