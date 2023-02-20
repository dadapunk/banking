package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Accounts.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing CheckingAccount entities.
 */
@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer> {

}

