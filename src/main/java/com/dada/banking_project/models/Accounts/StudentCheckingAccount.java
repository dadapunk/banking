package com.dada.banking_project.models.Accounts;

import com.dada.banking_project.models.Users.AccountHolder;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class StudentCheckingAccount extends CheckingAccount {

    // Monthly maintenance fee for student checking account
    private static final BigDecimal MONTHLY_MAINTENANCE_FEE = BigDecimal.ZERO;

    // Minimum balance for student checking account
    private static final BigDecimal MINIMUM_BALANCE = BigDecimal.ZERO;

    public StudentCheckingAccount(BigDecimal balance, String primaryOwner, String secondaryOwner, String status, AccountHolder accountHolder) {
        super(balance, primaryOwner, secondaryOwner, status, accountHolder);
        setMonthlyMaintenanceFee(MONTHLY_MAINTENANCE_FEE);
        setMinimumBalance(MINIMUM_BALANCE);
    }
    public StudentCheckingAccount() {
    }
    @Override
    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        if (!monthlyMaintenanceFee.equals(MONTHLY_MAINTENANCE_FEE)) {
            throw new IllegalArgumentException("Monthly maintenance fee for student checking account must be zero.");
        }
    }

    @Override
    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (!minimumBalance.equals(MINIMUM_BALANCE)) {
            throw new IllegalArgumentException("Minimum balance for student checking account must be zero.");
        }
    }
}

