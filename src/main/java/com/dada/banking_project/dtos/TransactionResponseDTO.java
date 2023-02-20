package com.dada.banking_project.dtos;

import lombok.Data;

@Data
public class TransactionResponseDTO {
    private String username;
    private double oldAmount;
    private double newAmount;

}
