package com.dada.banking_project.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class AccountHolderDTO {
        private String username;
        private String password;
        private LocalDate dateOfBirth;
        private String mailingAdress;
        private AddressDTO address;

        // Constructor, getters, and setters

        public AccountHolderDTO(String username, String password, LocalDate dateOfBirth, String mailingAdress, AddressDTO address) {
                this.username = username;
                this.password = password;
                this.dateOfBirth = dateOfBirth;
                this.mailingAdress = mailingAdress;
                this.address = address;
        }

        public AccountHolderDTO() {
        }
}



