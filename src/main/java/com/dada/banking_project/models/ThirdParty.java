package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ThirdParty extends User{
    @Id
    private String name;
    private String hashedkey;

    public ThirdParty(String hashedkey) {
        this.hashedkey = hashedkey;
    }

    public ThirdParty() {

    }
}

