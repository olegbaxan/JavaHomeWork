package com.step.person;

import java.time.LocalDate;

public class Person {
    private int personId;
    private String name;
    private String surname;
    private String description;
    private String phone;
    private String mobile;
    private String email;
    private final LocalDate regDate;
    private String idnp;

    public Person(String name, String surname, String description, String phone, String mobile, String email, String idnp, LocalDate today) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.regDate = today;
        this.idnp = idnp;
    }

    public void sendMeterInfo() {

    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getIdnp() {
        return idnp;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("Person (name=%s, surname=%s, phone=%s, mobil=%s, email=%s, idnp=%s, description=%s, regdate=%s)", name, surname, phone, mobile, email, idnp, description, regDate);
    }
}
