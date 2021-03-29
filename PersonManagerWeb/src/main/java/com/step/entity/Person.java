package edu.step.entity;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private IntegerProperty personId;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty description;
    private StringProperty phone;
    private StringProperty mobile;
    private StringProperty email;
    private ObjectProperty<LocalDate> regDate;
    private StringProperty idnp;
    private ObjectProperty<LocalDate> birthday;

    public Person(int personid, String name, String surname, String description, String phone, String mobil, String email, LocalDate regdate, String idnp, LocalDate birthday) {
        this.personId=new SimpleIntegerProperty(personid);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.description = new SimpleStringProperty(description);
        this.phone = new SimpleStringProperty(phone);
        this.mobile = new SimpleStringProperty(mobil);
        this.email = new SimpleStringProperty(email);
        this.regDate = new SimpleObjectProperty(regdate);
        this.idnp = new SimpleStringProperty(idnp);
        this.birthday = new SimpleObjectProperty(birthday);
    }
    public Person() {

    }

    public Person(int personid, String name, String surname) {
        this.personId=new SimpleIntegerProperty(personid);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public int getPersonId() {
        return personId.get();
    }

    public String getName() {
        return name.get();
    }

    public LocalDate getRegDate() {
        return regDate.get();
    }

    public String getIdnp() {
        return idnp.get();
    }

    public String getSurname() {
        return surname.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getMobile() {
        return mobile.get();
    }

    public String getEmail() {
        return email.get();
    }

    public void setPersonId(int ID) {
        this.personId.setValue(ID);
    }
    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setSurname(String surname) {
        this.surname.setValue(surname);
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }

    public void setMobile(String mobile) {
        this.mobile.setValue(mobile);
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate.setValue(regDate);
    }
    public void setIdnp(String idnp) {
        this.idnp.setValue(idnp);
    }
    public IntegerProperty personIdProperty() {
        return this.personId;
    }

    public StringProperty nameProperty() {
        return this.name;
    }

    public StringProperty surnameProperty() {
        return this.surname;
    }
    public StringProperty descriptionProperty() {
        return this.description;
    }

    public StringProperty phoneProperty() {
        return this.phone;
    }
    public StringProperty mobileProperty() {
        return this.mobile;
    }

    public StringProperty emailProperty() {
        return this.email;
    }
    public ObjectProperty regDateProperty() {
        return this.regDate;
    }
    public StringProperty idnpProperty() {
        return this.idnp;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty birthdayProperty() {
        return this.birthday;
    }

    public String toString() {
        return String.format("Person (personID =%s,name=%s, surname=%s, phone=%s, mobil=%s, email=%s, idnp=%s, description=%s, regdate=%s)", personId, name, surname, phone, mobile, email, idnp, description, regDate);
//        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", name, surname, phone, mobile, email, idnp, description, regDate);
    }
}
