package com.dada.banking_project.controller;

import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.models.User;
import com.dada.banking_project.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
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
    public List<AccountHolder> findAllAccountHolder()
    {
        return accountHolderService.findAllAccountHolder();
    }



}
