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
        private String secretKey;
        private LocalDate dateOfBirth;
        private String mailingAdress;
        private AddressDTO address;

        // Constructor, getters, and setters

        public AccountHolderDTO(String username, String secretKey, LocalDate dateOfBirth, String mailingAdress, AddressDTO address) {
                this.username = username;
                this.secretKey = secretKey;
                this.dateOfBirth = dateOfBirth;
                this.mailingAdress = mailingAdress;
                this.address = address;
        }

        public AccountHolderDTO() {
        }
}



