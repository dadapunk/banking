package com.dada.banking_project.models;

import jakarta.persistence.*;
import lombok.Getter;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal balance;
    private String secretKey;
    private LocalDate creationDate = LocalDate.now();
    private String primaryOwner;
    private String secondaryOwner;
    // FROZEN, ACTIVE ENUM?
    private String status;
    private BigDecimal penaltyFee;
//To accountholder
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;
    @OneToMany(mappedBy = "sender")
    private List<Transaction> transactionsSent;

    @OneToMany(mappedBy = "receiver")
    private List<Transaction> transactionsReceived;

    public Account() {
    }
    public Account(BigDecimal balance, String primaryOwner, String secondaryOwner,
                   String status, AccountHolder accountHolder) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.status = status;
        this.accountHolder = accountHolder;
    }

    public Account(BigDecimal balance, String primaryOwner, String status, AccountHolder accountHolder) {
        this.balance=balance;
        this.primaryOwner=primaryOwner;
        this.status=status;
        this.accountHolder=accountHolder;

    }

    public Account(String primaryOwner, AccountHolder accountHolder) {
    }

    //penalty fee
    //monthly maintenance Fee


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(String secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", primaryOwner='" + primaryOwner + '\'' +
                ", secondaryOwner='" + secondaryOwner + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
