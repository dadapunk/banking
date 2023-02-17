package com.dada.banking_project.models.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO {
    private Integer senderAccountId;
    private Integer receiverAccountId;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    public TransactionDTO(Integer senderAccountId, Integer receiverAccountId, BigDecimal amount,
                          LocalDateTime transactionDate) {
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.transactionDate = transactionDate.now();
    }
}

