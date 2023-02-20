package com.dada.banking_project.models.Users;

import com.dada.banking_project.models.Accounts.Account;
import com.dada.banking_project.models.Address;
import com.dada.banking_project.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;

/**
 * This class represents an account holder, a type of user that can own multiple bank accounts.
 */
@Getter
@Setter
@Entity
public class AccountHolder extends User {

    /**
     * The date of birth of the account holder.
     */
    private LocalDate dateOfBirth;

    /**
     * The mailing address of the account holder.
     */
    private String mailingAdress;

    /**
     * The address of the account holder.
     */
    @Embedded
    private Address address;

    /**
     * A list of accounts owned by the account holder.
     */
    @OneToMany(mappedBy = "accountHolder")
    @JsonIgnore
    private List<Account> accounts;



    public AccountHolder(Long id, String name, String username, String password, Collection<Role> roles, LocalDate dateOfBirth, String mailingAdress, Address address) {
        super(id, name, username, password, roles);
        this.dateOfBirth = dateOfBirth;
        this.mailingAdress = mailingAdress;
        this.address = address;
    }


    public AccountHolder() {

    }

    public AccountHolder(String accountHolderTest, String accountHolderTest1, String s, LocalDate of, String s1) {
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
