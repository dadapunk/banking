package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CreditCardAccount extends Account {
    // Default credit limit for CreditCards
    private static final BigDecimal DEFAULT_CREDIT_LIMIT = BigDecimal.valueOf(100);
    // Default interest rate for CreditCards
    private static final BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.2);

    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCardAccount(BigDecimal balance, String primaryOwner,
                      String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);

        // Set credit limit to default value if not specified
        this.creditLimit = DEFAULT_CREDIT_LIMIT;

        // Set interest rate to default value if not specified
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public CreditCardAccount() {
    }

    /**
     * Set the credit limit for this CreditCard account.
     *
     * @param creditLimit The credit limit to set, must be greater than 100 and less than or equal to 100000
     * @throws IllegalArgumentException if credit limit is less than 100 or greater than 100000
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit.compareTo(BigDecimal.valueOf(100)) < 0 || creditLimit.compareTo(BigDecimal.valueOf(100000)) > 0) {
            throw new IllegalArgumentException("Credit limit for CreditCards must be between 100 and 100000");
        }
        this.creditLimit = creditLimit;
    }

    /**
     * Get the credit limit for this CreditCard account.
     *
     * @return The credit limit for this account.
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * Set the interest rate for this CreditCard account.
     *
     * @param interestRate The interest rate to set, must be less than or equal to 0.2 and greater than or equal to 0.1
     * @throws IllegalArgumentException if interest rate is greater than 0.2 or less than 0.1
     */
    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(BigDecimal.valueOf(0.2)) > 0 || interestRate.compareTo(BigDecimal.valueOf(0.1)) < 0) {
            throw new IllegalArgumentException("Interest rate for CreditCards must be between 0.1 and 0.2");
        }
        this.interestRate = interestRate;
    }

    /**
     * Get the interest rate for this CreditCard account.
     *
     * @return The interest rate for this account.
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }
}