package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class SavingAccount extends Account{
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);
    private BigDecimal minimumBalance =  BigDecimal.valueOf(1000);

    public SavingAccount(BigDecimal balance, String primaryOwner,
                         String secondaryOwner, String status, AccountHolder accountHolder) {
                        super(balance, primaryOwner, secondaryOwner, status, accountHolder);
                        this.interestRate = interestRate;
                        this.minimumBalance = minimumBalance;
    }
    public SavingAccount() {
    }
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
