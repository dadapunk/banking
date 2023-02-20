package com.dada.banking_project.models.Accounts;

import com.dada.banking_project.models.Transaction;
import com.dada.banking_project.models.Users.AccountHolder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

/**
 * This class represents a generic account.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Getter
@Setter
public class Account {

    /**
     * The length of the secret key in bytes.
     */
    private static final int KEY_LENGTH_BYTES = 32;

    /**
     * A secure random number generator.
     */
    private static final SecureRandom random = new SecureRandom();

    /**
     * The penalty fee for this account.
     */
    private static final BigDecimal PENALTY_FEE = BigDecimal.valueOf(40);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal balance;
    private String secretKey;

    private LocalDate creationDate = LocalDate.now();
    private String primaryOwner;
    private String secondaryOwner;
    private String status;
    private BigDecimal penaltyFee;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")

    private AccountHolder accountHolder;
    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<Transaction> transactionsSent;

    @OneToMany(mappedBy = "receiver")
    @JsonIgnore
    private List<Transaction> transactionsReceived;

    public Account() {
    }
    public Account(BigDecimal balance, String primaryOwner, String secondaryOwner,
                   String status, AccountHolder accountHolder) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.status = status;
        this.accountHolder = accountHolder;
        setSecretKey();
        setPenaltyFee(PENALTY_FEE);
    }

    public Account(BigDecimal balance, String primaryOwner, String status, AccountHolder accountHolder) {
        this.balance=balance;
        this.primaryOwner=primaryOwner;
        this.status=status;
        this.accountHolder=accountHolder;
        setSecretKey();
        setPenaltyFee(PENALTY_FEE);
    }

    public Account(String primaryOwner, AccountHolder accountHolder) {
    }
    public void setSecretKey() {
        byte[] keyBytes = new byte[KEY_LENGTH_BYTES];
        random.nextBytes(keyBytes);
        String key = Base64.getEncoder().encodeToString(keyBytes);
        this.secretKey = key;
    }

    /**
     * Checks whether the account has sufficient balance to make a transaction.
     * @param amount The amount to check against the account balance.
     * @return true if the account has sufficient balance, false otherwise.
     */
    public boolean checkBalance(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }

    /**
     * Checks whether the provided name matches either the primary or secondary account owner name.
     * @param name The name to check against the account owner names.
     * @return true if the name matches either the primary or secondary account owner name, false otherwise.
     */
    public boolean checkOwnerName(String name) {
        return this.primaryOwner.equals(name) || (secondaryOwner != null && this.secondaryOwner.equals(name));
    }


}
