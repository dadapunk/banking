package com.dada.banking_project.repositories;

import com.dada.banking_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
