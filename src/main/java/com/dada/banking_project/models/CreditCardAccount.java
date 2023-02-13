package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
public class CreditCardAccount extends Account{
    @Id
    private Integer id;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;
    private BigDecimal penaltyFee;

    public CreditCardAccount(BigDecimal creditLimit, BigDecimal interestRate, BigDecimal penaltyFee) {
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.penaltyFee = penaltyFee;
    }

    public CreditCardAccount() {
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    @Override
    public String toString() {
        return "CreditCardAccount{" +
                "creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                ", penaltyFee=" + penaltyFee +
                '}';
    }
}
