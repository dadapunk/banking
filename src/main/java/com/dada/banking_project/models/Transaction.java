package com.dada.banking_project.models;

import com.dada.banking_project.models.Accounts.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal amount;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="sender_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Account sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Account receiver;


    public Transaction() {
    }

    public Transaction(BigDecimal amount, LocalDateTime date, Account sender, Account receiver) {
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
    }
}
