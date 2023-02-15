package com.dada.banking_project.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressDTO {
        private String city;
        private String state;
        private String street;
        private Integer zipCode;

    public AddressDTO(String city, String state, String street, Integer zipCode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;

    }
}


