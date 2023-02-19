package com.dada.banking_project.repositories;

import com.dada.banking_project.models.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository responsible for handling the persistence and retrieval of AccountHolder entities in the database.
 */
@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

}

