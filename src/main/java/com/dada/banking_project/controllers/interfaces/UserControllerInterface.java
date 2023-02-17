package com.dada.banking_project.controllers.interfaces;

import com.dada.banking_project.models.User;
import java.util.List;

/**
 * Interface for OldUserController. Contains methods for handling user related operations
 */
public interface UserControllerInterface {
    /**
     * Retrieves a list of all users
     *
     * @return list of all users
     */
    List<User> getUsers();

    /**
     * Saves a new user
     *
     * @param user the user to be saved
     * @return the saved user
     */
    User saveUser(User user);
}