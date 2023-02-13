package com.dada.banking_project.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String mailingAdress;
    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
