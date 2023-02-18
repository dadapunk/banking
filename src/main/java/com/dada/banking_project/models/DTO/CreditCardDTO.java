package com.dada.banking_project.models.DTO;

import java.math.BigDecimal;

public class CreditCardDTO {
    private Long id;
    private BigDecimal balance;
    private String primaryOwner;
    private String secondaryOwner;
    private String status;
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCardDTO(Long id, BigDecimal balance, String primaryOwner, String secondaryOwner,
                                String status, BigDecimal creditLimit, BigDecimal interestRate) {
        this.id = id;
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.status = status;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public String getSecondaryOwner() {
        return secondaryOwner;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
