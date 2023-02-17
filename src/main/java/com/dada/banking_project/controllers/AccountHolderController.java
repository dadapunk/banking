package com.dada.banking_project.controllers;

import com.dada.banking_project.models.Account;
import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.models.DTO.TransactionDTO;
import com.dada.banking_project.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-holder/")
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder)
    {
        return accountHolderService.addAccountHolder(accountHolder);
    }
    // Get all AccountHolders
    @GetMapping("/all")
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
    @GetMapping("/check-accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> checkBalanceAccounts(@PathVariable Integer id) {
        return accountHolderService.checkBalanceAccounts(id);
    }
    // Get all AccountHolders
    /*@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllAccount(){
        return acc.findAllAccount();
    }*/

}
