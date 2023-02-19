package com.dada.banking_project.controllers;

import com.dada.banking_project.models.Account;
import com.dada.banking_project.models.DTO.AccountDTO;
import com.dada.banking_project.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents the REST controller for admin-related account operations.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * This method handles the creation of a new account.
     * @param accountDTO The DTO representing the new account to be created.
     * @return The created account.
     */
    @PostMapping("/account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addAccount(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO);
        return adminService.addAccount(accountDTO);
    }

    /**
     * This method handles the retrieval of all accounts.
     * @return A list of all accounts.
     */
    @GetMapping("/account-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllAccount(){
        return adminService.findAllAccounts();
    }

    /**
     * This method handles the retrieval of the balance for a specific account.
     * @param id The id of the account.
     * @return The balance of the specified account.
     */
    @GetMapping("/account/{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getAccountBalance(@PathVariable Integer id) {
        return adminService.getAccountBalance(id);
    }

    /**
     * This method handles the updating of the balance for a specific account.
     * @param id The id of the account.
     * @param balance The new balance value.
     * @return The updated account.
     */
    @PutMapping("/account/{id}/update-balance")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccountBalance(@PathVariable Integer id, @RequestParam BigDecimal balance) {
        return adminService.updateAccountBalance(id, balance);
    }

}
