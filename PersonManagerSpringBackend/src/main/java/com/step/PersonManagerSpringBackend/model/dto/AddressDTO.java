package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Address;

public class AddressDTO {

    private int addressid;
    private String city;
    private String raion;
    private String street;
    private String houseNumber;

    public AddressDTO() {

    }

    public AddressDTO(int addressid, String city, String raion, String street, String houseNumber) {
        this.addressid = addressid;
        this.city = city;
        this.raion = raion;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public int getAddressid() {
        return addressid;
    }

    public static AddressDTO from(Address address) {
        final AddressDTO adressDTO = new AddressDTO(address.getAddressid(), address.getCity(), address.getRaion(), address.getStreet(), address.getHouseNumber());

        return adressDTO;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRaion() {
        return raion;
    }

    public void setRaion(String raion) {
        this.raion = raion;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
