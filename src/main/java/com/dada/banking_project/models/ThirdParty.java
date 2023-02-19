package com.dada.banking_project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * ThirdParty class represents a third-party user who can initiate transactions on behalf of an account holder
 */
@Entity
@Getter
@Setter
public class ThirdParty extends User{

    /**
     * A hashed key that can be used to authenticate transactions initiated by the third-party
     */
    private String hashedkey;
    public ThirdParty(Long id, String name, String username, String password, Collection<Role> roles) {
        super(id, name, username, password, roles);
        this.hashedkey = hashedkey;
    }

    public ThirdParty() {

    }
}

