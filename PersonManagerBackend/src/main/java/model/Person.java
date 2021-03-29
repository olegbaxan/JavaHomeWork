package com.step.entity;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private Integer personId;
    private String name;
    private String surname;
    private String description;
    private String phone;
    private String mobile;
    private String email;
    private LocalDate regDate;
    private String idnp;
    private LocalDate birthday;

    public Person(int personid, String name, String surname, String description, String phone, String mobil, String email, LocalDate regdate, String idnp, LocalDate birthday) {
        this.personId=personid;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.phone = phone;
        this.mobile = mobil;
        this.email = email;
        this.regDate = regdate;
        this.idnp = idnp;
        this.birthday = birthday;
    }
    public Person() {

    }

//    public Person(int personid, String name, String surname) {
//        this.personId=new SimpleIntegerProperty(personid);
//        this.name = new SimpleStringProperty(name);
//        this.surname = new SimpleStringProperty(surname);
//    }

    public Person(String name, String surname, String description, String phone, String mobile, String email, LocalDate regdate, String idnp, LocalDate birthday) {

        this.name = name;
        this.surname = surname;
        this.description = description;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.regDate = regdate;
        this.idnp = idnp;
        this.birthday = birthday;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
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

    public LocalDate getRegDate() {
        return regDate;
    }

    public String getIdnp() {
        return idnp;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String toString() {
        return String.format("Person (personID =%s,name=%s, surname=%s, phone=%s, mobil=%s, email=%s, idnp=%s, description=%s, regdate=%s, birthday=%s)", personId, name, surname, phone, mobile, email, idnp, description, regDate,birthday);
//        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", name, surname, phone, mobile, email, idnp, description, regDate);
    }
}
