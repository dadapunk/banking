package com.dada.banking_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class AccountHolder extends User{

    private LocalDate dateOfBirth;
    private String mailingAdress;
    @Embedded
    private Address address;

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
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
