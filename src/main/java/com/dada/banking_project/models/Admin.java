package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Admin extends User{
    private String name;

    public Admin(String name, String name1) {
        super(name);
        this.name = name1;
    }

    public Admin() {

    }
}
