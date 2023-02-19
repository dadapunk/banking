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

    private String primaryOrSecondaryOwnersName;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    /**
     * Constructs a new TransactionDTO with the specified values.
     *
     * @param senderAccountId the ID of the account that is sending the transaction
     * @param receiverAccountId the ID of the account that is receiving the transaction
     * @param primaryOrSecondaryOwnersName the name of the primary or secondary owner of the account sending the transaction
     * @param amount the amount of the transaction
     * @param transactionDate the date and time the transaction occurred
     */
    public TransactionDTO(Integer senderAccountId, Integer receiverAccountId, String primaryOrSecondaryOwnersName, BigDecimal amount,
                          LocalDateTime transactionDate) {
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.primaryOrSecondaryOwnersName = primaryOrSecondaryOwnersName;
        this.transactionDate = transactionDate.now();
    }
}
