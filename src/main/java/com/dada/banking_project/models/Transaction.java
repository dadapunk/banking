package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Transaction {
    @Id
    private Integer id;

    private BigDecimal amount;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Account sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private Account receiver;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, LocalDate date, Account sender, Account receiver) {
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
}
