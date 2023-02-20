package com.dada.banking_project.dtos;

import lombok.Data;

@Data
public class ThirdPartyTransactionDTO {
    private Long idAccountReciever;
    private Long idAccountSender;
    private double amount;
    private String hashedKey;
}
