package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
public class CheckingAccount extends Account{
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(250);
    private static final BigDecimal DEFAULT_MONTHLY_MAINTENANCE_FEE = BigDecimal.valueOf(12);

    private String secondaryOwner;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;

    public CheckingAccount(BigDecimal balance, String primaryOwner, String secondaryOwner,
                           String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, status, accountHolder);

        this.secondaryOwner = secondaryOwner;
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
        this.monthlyMaintenanceFee = DEFAULT_MONTHLY_MAINTENANCE_FEE;

        // Check if balance is less than minimum and throw exception if true
        if (balance.compareTo(DEFAULT_MINIMUM_BALANCE) < 0) {
            throw new IllegalArgumentException("Minimum balance for Checking accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
    }

    public CheckingAccount(String secondaryOwner, String primaryOwner, AccountHolder accountHolder) {
        super(primaryOwner, accountHolder);
        this.secondaryOwner = secondaryOwner;
        if (accountHolder.getAge() < 24) {
            this.setMinimumBalance(BigDecimal.ZERO);
            this.setMonthlyMaintenanceFee(BigDecimal.ZERO);
        } else {
            this.setMinimumBalance(DEFAULT_MINIMUM_BALANCE);
            this.setMonthlyMaintenanceFee(DEFAULT_MONTHLY_MAINTENANCE_FEE);
        }
    }

    public CheckingAccount() {
    }

    public CheckingAccount(String secondaryOwner) {
        this.secondaryOwner=secondaryOwner;
    }

    /**
     * Set the minimum balance for this Checking account.
     *
     * @param minimumBalance The minimum balance to set, must be greater than or equal to 250.
     * @throws IllegalArgumentException if minimum balance is less than 250.
     */
    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.compareTo(BigDecimal.valueOf(250)) < 0) {
            throw new IllegalArgumentException("Minimum balance for Checking accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
        this.minimumBalance = minimumBalance;
    }

    /**
     * Set the monthly maintenance fee for this Checking account.
     *
     * @param monthlyMaintenanceFee The monthly maintenance fee to set, must be greater than or equal to 12.
     * @throws IllegalArgumentException if monthly maintenance fee is less than 12.
     */
    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        if (monthlyMaintenanceFee.compareTo(BigDecimal.valueOf(12)) < 0) {
            throw new IllegalArgumentException("Monthly maintenance fee for Checking accounts is " + DEFAULT_MONTHLY_MAINTENANCE_FEE);
        }
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

}