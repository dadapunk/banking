package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
public class SavingsAccount extends Account{
    @Id
    private Integer id;
    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    public SavingsAccount(BigDecimal interestRate, BigDecimal minimumBalance) {
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public SavingsAccount() {
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
