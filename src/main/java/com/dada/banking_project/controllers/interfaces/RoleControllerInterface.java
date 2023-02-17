package com.dada.banking_project.controllers.interfaces;

import com.dada.banking_project.dtos.RoleToUserDTO;
import com.dada.banking_project.models.Role;

public interface RoleControllerInterface {
    /**
     * Save a new role
     *
     * @param role the role to be saved
     */
    void saveRole(Role role);

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO object containing the username and role name to be added to the user
     */
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}