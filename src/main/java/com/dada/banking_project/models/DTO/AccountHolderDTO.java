package com.dada.banking_project.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * A data transfer object representing an account holder.
 */
@Data
@Getter
@Setter
public class AccountHolderDTO {

        /**
         * The username of the account holder.
         */
        private String username;

        /**
         * The secret key used for authentication.
         */
        private String secretKey;

        /**
         * The date of birth of the account holder.
         */
        private LocalDate dateOfBirth;

        /**
         * The mailing address of the account holder.
         */
        private String mailingAdress;

        /**
         * The address object representing the address of the account holder.
         */
        private AddressDTO address;

        /**
         * Constructs a new AccountHolderDTO object with the given parameters.
         *
         * @param username the username of the account holder.
         * @param secretKey the secret key used for authentication.
         * @param dateOfBirth the date of birth of the account holder.
         * @param mailingAdress the mailing address of the account holder.
         * @param address the address object representing the address of the account holder.
         */
        public AccountHolderDTO(String username, String secretKey, LocalDate dateOfBirth, String mailingAdress, AddressDTO address) {
                this.username = username;
                this.secretKey = secretKey;
                this.dateOfBirth = dateOfBirth;
                this.mailingAdress = mailingAdress;
                this.address = address;
        }

        /**
         * Constructs a new, empty AccountHolderDTO object.
         */
        public AccountHolderDTO() {
        }
}
