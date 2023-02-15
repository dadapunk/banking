package com.dada.banking_project.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
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
    private List<Account> accounts;

    public AccountHolder(String name, LocalDate dateOfBirth, String mailingAdress, Address address) {
        super(name);
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
