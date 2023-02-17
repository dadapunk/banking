package com.dada.banking_project.controllers;

import com.dada.banking_project.models.User;
import com.dada.banking_project.services.OldUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OldUserController {
    @Autowired
    OldUserService oldUserService;
    //Post User
    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user)
    {
        return oldUserService.addUser(user);
    }
    /*get all Users*/
    @GetMapping("/user-all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllBlogPost() {
        return oldUserService.findAllUser();
    }
    //get author by ID
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) {
        return oldUserService.findById(id);
    }
    // Delete User
    @DeleteMapping("/user-delete/{id}")
    public void deleteById(@PathVariable Long id) {
        oldUserService.deleteUserById(id);
    }
    // Update User
    @PatchMapping("/update-user")
    public User updateUser(@RequestParam Long id, @RequestParam String name) {
        return oldUserService.updateUser(id, name);
    }
}
