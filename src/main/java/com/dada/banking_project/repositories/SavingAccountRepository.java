package com.dada.banking_project.repositories;

import com.dada.banking_project.models.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Integer> {
}
