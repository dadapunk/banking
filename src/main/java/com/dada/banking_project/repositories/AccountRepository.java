package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the Account entity.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Finds all accounts associated with a given account holder ID.
     *
     * @param accountHolderId The ID of the account holder whose accounts to find.
     * @return A list of accounts associated with the given account holder ID.
     */
    List<Account> findByAccountHolder_Id(Integer accountHolderId);
}
