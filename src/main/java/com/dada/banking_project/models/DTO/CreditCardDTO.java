package com.dada.banking_project.models.DTO;

import java.math.BigDecimal;

/**
 * This class represents a Credit Card Data Transfer Object (DTO).
 */
public class CreditCardDTO {

    /**
     * The id of the credit card.
     */
    private Long id;

    /**
     * The balance of the credit card.
     */
    private BigDecimal balance;

    /**
     * The primary owner of the credit card.
     */
    private String primaryOwner;

    /**
     * The secondary owner of the credit card.
     */
    private String secondaryOwner;

    /**
     * The status of the credit card.
     */
    private String status;

    /**
     * The credit limit of the credit card.
     */
    private BigDecimal creditLimit;

    /**
     * The interest rate of the credit card.
     */
    private BigDecimal interestRate;

    /**
     * Constructs a new CreditCardDTO object with the specified values.
     *
     * @param id              the id of the credit card
     * @param balance         the balance of the credit card
     * @param primaryOwner    the primary owner of the credit card
     * @param secondaryOwner  the secondary owner of the credit card
     * @param status          the status of the credit card
     * @param creditLimit     the credit limit of the credit card
     * @param interestRate    the interest rate of the credit card
     */
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

    /**
     * Returns the id of the credit card.
     *
     * @return the id of the credit card
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the balance of the credit card.
     *
     * @return the balance of the credit card
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Returns the primary owner of the credit card.
     *
     * @return the primary owner of the credit card
     */
    public String getPrimaryOwner() {
        return primaryOwner;
    }

    /**
     * Returns the secondary owner of the credit card.
     *
     * @return the secondary owner of the credit card
     */
    public String getSecondaryOwner() {
        return secondaryOwner;
    }

    /**
     * Returns the status of the credit card.
     *
     * @return the status of the credit card
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the credit limit of the credit card.
     *
     * @return the credit limit of the credit card
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Returns the interest rate of the credit card.
     *
     * @return the interest rate of the credit card
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
