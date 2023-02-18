package com.dada.banking_project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SavingAccount extends Account {
    private static final BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.0025);
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(1000);
    private static final BigDecimal MAX_INTEREST_RATE = BigDecimal.valueOf(0.5);

    @Column(precision = 4, scale = 4)
    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    public SavingAccount(BigDecimal balance, String primaryOwner, String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);
        this.interestRate = DEFAULT_INTEREST_RATE;
        setMinimumBalance(balance);
    }

    public SavingAccount() {
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(DEFAULT_INTEREST_RATE) == 0) {
            this.interestRate = DEFAULT_INTEREST_RATE;
        } else if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            throw new IllegalArgumentException("Interest rate cannot be greater than " + MAX_INTEREST_RATE);
        } else {
            this.interestRate = interestRate;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.compareTo(DEFAULT_MINIMUM_BALANCE) < 0) {
            throw new IllegalArgumentException("Minimum balance for Savings accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
}
