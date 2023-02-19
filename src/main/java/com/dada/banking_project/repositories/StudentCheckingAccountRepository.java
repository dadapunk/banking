package com.dada.banking_project.repositories;

import com.dada.banking_project.models.StudentCheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository for managing student checking accounts in the database.
 */
@Repository
public interface StudentCheckingAccountRepository extends JpaRepository<StudentCheckingAccount, Integer> {
}

