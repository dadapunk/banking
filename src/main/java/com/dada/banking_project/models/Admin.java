package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Admin extends User{

    public Admin(String name) {
        super(name);

    }
    public Admin() {

    }
}
