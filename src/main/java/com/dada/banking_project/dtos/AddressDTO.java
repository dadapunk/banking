package com.dada.banking_project.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressDTO {

    /**
     * The city where the address is located.
     */
    private String city;

    /**
     * The state where the address is located.
     */
    private String state;

    /**
     * The street where the address is located.
     */
    private String street;

    /**
     * The zip code of the address.
     */
    private Integer zipCode;

    /**
     * Creates a new AddressDTO object with the specified city, state, street, and zip code.
     * @param city the city where the address is located
     * @param state the state where the address is located
     * @param street the street where the address is located
     * @param zipCode the zip code of the address
     */
    public AddressDTO(String city, String state, String street, Integer zipCode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }
}

