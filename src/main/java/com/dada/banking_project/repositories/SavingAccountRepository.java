package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Accounts.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The SavingAccountRepository interface provides methods to perform CRUD operations
 * on SavingAccount entities in the database.
 */
@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Integer> {
}

