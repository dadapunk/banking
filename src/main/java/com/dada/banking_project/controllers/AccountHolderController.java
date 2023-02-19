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

/**
 * The AccountHolderController class handles HTTP requests related to AccountHolder entities.
 */
@RestController
@RequestMapping("/api/account-holder/")
public class AccountHolderController {

    /**
     * The AccountHolderService used to perform business logic related to AccountHolder entities.
     */
    @Autowired
    AccountHolderService accountHolderService;

    /**
     * Adds a new AccountHolder to the database.
     * @param accountHolder The AccountHolder object to be added.
     * @return The newly created AccountHolder object.
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder)
    {
        return accountHolderService.addAccountHolder(accountHolder);
    }

    /**
     * Retrieves a list of all AccountHolder entities in the database.
     * @return The list of all AccountHolder entities.
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAllAccountHolder(){
        return accountHolderService.findAllAccountHolder();
    }

    /**
     * Transfers funds between two Account entities.
     * @param transactionDTO The transaction details.
     */
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.OK)
    public void transferFunds(@RequestBody TransactionDTO transactionDTO) {
        accountHolderService.transaction(transactionDTO);
    }

    /**
     * Retrieves a list of all Account entities associated with a particular AccountHolder.
     * @param id The ID of the AccountHolder.
     * @return The list of Account entities associated with the AccountHolder.
     */
    @GetMapping("/check-accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> checkBalanceAccounts(@PathVariable Integer id) {
        return accountHolderService.checkBalanceAccounts(id);
    }
}
