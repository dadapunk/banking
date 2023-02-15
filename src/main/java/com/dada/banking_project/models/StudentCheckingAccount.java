package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentCheckingAccount extends CheckingAccount {

    public StudentCheckingAccount(String secondaryOwner) {
        super(secondaryOwner);
    }

    public StudentCheckingAccount() {
    }
}
