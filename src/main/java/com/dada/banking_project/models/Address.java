package com.dada.banking_project.models;

import jakarta.persistence.*;


@Embeddable
public class Address {

    private Integer addressId;
    private String city;
    private String state;
    private String street;
    private String zipCode;

    public Address(String city, String state, String street, String zipCode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address() {

    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + addressId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
