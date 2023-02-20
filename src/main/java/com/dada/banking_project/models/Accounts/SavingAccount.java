package com.dada.banking_project.models.Accounts;

import com.dada.banking_project.models.Users.AccountHolder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * SavingAccount is a subclass of the Account class that represents a savings account.
 * The SavingAccount class contains the default interest rate, minimum balance, and maximum interest rate.
 */
@Entity
@Getter
@Setter
public class SavingAccount extends Account {
    /** The default interest rate for saving accounts. */
    private static final BigDecimal DEFAULT_INTEREST_RATE = BigDecimal.valueOf(0.0025);
    /** The default minimum balance for saving accounts. */
    private static final BigDecimal DEFAULT_MINIMUM_BALANCE = BigDecimal.valueOf(1000);
    /** The maximum interest rate for saving accounts. */
    private static final BigDecimal MAX_INTEREST_RATE = BigDecimal.valueOf(0.5);

    /** The interest rate for this saving account. */
    @Column(precision = 4, scale = 4)
    private BigDecimal interestRate;
    /** The minimum balance for this saving account. */
    private BigDecimal minimumBalance;

    public SavingAccount(BigDecimal balance, String primaryOwner, String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);
        this.interestRate = DEFAULT_INTEREST_RATE;
        setMinimumBalance(balance);
    }

    public SavingAccount() {
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    /**
     * Sets the interest rate for the SavingAccount. If the interest rate is equal to the default interest rate,
     * sets the interest rate to the default interest rate. If the interest rate is greater than the maximum interest
     * rate, throws an exception. Otherwise, sets the interest rate to the given value.
     *
     * @param interestRate the interest rate to set
     * @throws IllegalArgumentException if the interest rate is greater than the maximum interest rate
     */
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

    /**
     * Sets the minimum balance for this Savings account.
     *
     * @param minimumBalance the minimum balance to set
     * @throws IllegalArgumentException if the minimum balance is less than the default minimum balance for Savings accounts
     */
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
