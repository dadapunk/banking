package com.dada.banking_project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SavingAccount extends Account{
    private static final BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.0025);
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(1000);

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    public SavingAccount(BigDecimal balance, String primaryOwner, String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);

        this.interestRate = interestRate == null ? DEFAULT_INTEREST_RATE : interestRate;

        if (balance.compareTo(DEFAULT_MINIMUM_BALANCE) < 0) {
            throw new IllegalArgumentException("Minimum balance for Savings accounts is " + DEFAULT_MINIMUM_BALANCE);
        }

        this.minimumBalance = balance;
    }

    public SavingAccount() {
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(BigDecimal.valueOf(0.5)) > 0) {
            throw new IllegalArgumentException("Interest rate cannot be greater than 0.5");
        }
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new IllegalArgumentException("Minimum balance for Savings accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
}
