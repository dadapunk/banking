package com.dada.banking_project.repositories;

import com.dada.banking_project.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used to provide CRUD operations for the Admin entity.
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}

