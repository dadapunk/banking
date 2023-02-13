package com.dada.banking_project.controller;

import com.dada.banking_project.models.User;
import com.dada.banking_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    //Post User
    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    /*get all Users*/
    @GetMapping("/user-all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllBlogPost() {
        return userService.findAllUser();
    }
    //get author by ID
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    // Delete User
    @DeleteMapping("/user-delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
    // Update User
    @PatchMapping("/update-user")
    public User updateUser(@RequestParam Integer id, @RequestParam String name) {
        return userService.updateUser(id, name);
    }
}
