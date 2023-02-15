package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SavingAccount extends Account{
    // Default interest rate for Savings accounts
    private static final BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.0025);
    // Minimum balance for Savings accounts
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(1000);

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    public SavingAccount(BigDecimal balance, String primaryOwner,
                         String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);

        // Set interest rate to default value if not specified
        this.interestRate = DEFAULT_INTEREST_RATE;

        // Check if balance is less than minimum and throw exception if true
        if (balance.compareTo(DEFAULT_MINIMUM_BALANCE) < 0) {
            throw new IllegalArgumentException("Minimum balance for Savings accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
        // Set minimum balance to default value if not specified
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public SavingAccount() {
    }

    /**
     * Set the interest rate for this Savings account.
     *
     * @param interestRate The interest rate to set, must be less than or equal to 0.5
     * @throws IllegalArgumentException if interest rate is greater than 0.5
     */
    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(BigDecimal.valueOf(0.5)) > 0) {
            throw new IllegalArgumentException("Interest rate cannot be greater than 0.5");
        }
        this.interestRate = interestRate;
    }

    /**
     * Get the interest rate for this Savings account.
     *
     * @return The interest rate for this account.
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Set the minimum balance for this Savings account.
     *
     * @param minimumBalance The minimum balance to set, must be greater than or equal to 100.
     * @throws IllegalArgumentException if minimum balance is less than 100.
     */
    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new IllegalArgumentException("Minimum balance for Savings accounts is " + DEFAULT_MINIMUM_BALANCE);
        }
        this.minimumBalance = minimumBalance;
    }

    /**
     * Get the minimum balance for this Savings account.
     *
     * @return The minimum balance for this account.
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
}