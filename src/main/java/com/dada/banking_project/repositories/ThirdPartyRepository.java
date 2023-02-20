package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, String> {
    ThirdParty findByHashedKey(String hashedKey);
}
