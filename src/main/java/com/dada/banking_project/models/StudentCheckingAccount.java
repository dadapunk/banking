package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentCheckingAccount extends Account{
    @Id
    private Integer id;

    public StudentCheckingAccount() {
    }
}
