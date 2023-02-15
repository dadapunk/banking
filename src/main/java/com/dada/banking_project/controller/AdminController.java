package com.dada.banking_project.controller;

import com.dada.banking_project.models.Account;
import com.dada.banking_project.models.AccountHolder;
import com.dada.banking_project.models.DTO.AccountDTO;
import com.dada.banking_project.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    AdminService adminService;

    //Post an Account
    @PostMapping("/account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addAccount(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO);
        return adminService.addAccount(accountDTO);
    }
    //Get all accounts
    @GetMapping("/account-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findAllAccount(){
        return adminService.findAllAccounts();
    }

    // Get account balance
    @GetMapping("/account/{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getAccountBalance(@PathVariable Integer id) {
        return adminService.getAccountBalance(id);
    }

    // Update account balance
    @PutMapping("/account/{id}/update-balance")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccountBalance(@PathVariable Integer id, @RequestParam BigDecimal balance) {
        return adminService.updateAccountBalance(id, balance);
    }



}
