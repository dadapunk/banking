package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
public class CheckingAccount extends Account{
    //private BigDecimal balance;

    @Id
    private Integer id;
    private String secondaryOwner;

    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;

    public CheckingAccount(String secondaryOwner, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        this.secondaryOwner = secondaryOwner;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public CheckingAccount() {

    }
}
