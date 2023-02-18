package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Account;
import com.dada.banking_project.models.CheckingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer> {


}
