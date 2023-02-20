package com.dada.banking_project.models.Users;

import com.dada.banking_project.models.Role;
import jakarta.persistence.Entity;

import java.util.Collection;


/**
 * This class represents an administrator, a type of user with elevated privileges.
 */
@Entity
public class Admin extends User {

    /**
     * Creates a new instance of the Admin class.
     * @param id The ID of the administrator.
     * @param name The name of the administrator.
     * @param username The username of the administrator.
     * @param password The password of the administrator.
     * @param roles The roles assigned to the administrator.
     */
    public Admin(Long id, String name, String username, String password, Collection<Role> roles) {
        super(id, name, username, password, roles);
    }

    /**
     * Creates a new instance of the Admin class.
     */
    public Admin() {

    }
}


