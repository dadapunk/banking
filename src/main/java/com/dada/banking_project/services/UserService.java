package com.dada.banking_project.services;

import com.dada.banking_project.models.User;
import com.dada.banking_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User name is required");
        }
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "The User you are looking for doesn't exist in the database");
    }

    public void deleteUserById(Integer id) {
        userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "The User does not exist"));
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The user does not exist"));
        if (user.getName() == null || user.getName().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User name is required");
        user.setName(name);
        return userRepository.save(user);
    }
}
