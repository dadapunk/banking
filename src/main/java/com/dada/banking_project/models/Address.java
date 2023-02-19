package com.dada.banking_project.models;

import jakarta.persistence.*;


/**
 * This class represents a postal address.
 */
@Embeddable
public class Address {

    /**
     * The city of the address.
     */
    private String city;

    /**
     * The state or province of the address.
     */
    private String state;

    /**
     * The street of the address.
     */
    private String street;

    /**
     * The ZIP or postal code of the address.
     */
    private Integer zipCode;

    public Address(String city, String state, String street, Integer zipCode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
