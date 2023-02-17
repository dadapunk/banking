package com.dada.banking_project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;


@Entity
public class Admin extends User{

    public Admin(Long id, String name, String username, String password, Collection<Role> roles) {
        super(id, name, username, password, roles);
    }

    public Admin() {

    }
}
