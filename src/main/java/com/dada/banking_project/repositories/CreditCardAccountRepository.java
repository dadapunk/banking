package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Accounts.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface extends the JpaRepository interface for the CreditCardAccount entity.
 * It provides access to basic CRUD operations for the CreditCardAccount entity.
 */
@Repository
public interface CreditCardAccountRepository extends JpaRepository<CreditCardAccount, Integer> {

}