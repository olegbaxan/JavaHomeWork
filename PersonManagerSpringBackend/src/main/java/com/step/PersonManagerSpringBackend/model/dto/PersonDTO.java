package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {

    private Integer personId;
    private String name;
    private String surname;
    private String description;
    private String phone;
    private String mobile;
    private String email;
    private double wallet;
    private LocalDate regDate;
    private String idnp;

    public PersonDTO() {
    }

    public PersonDTO(Integer personId, String name, String surname, String description, String phone, String mobile, String email, double wallet, LocalDate regDate, String idnp, List<Integer> flat) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.wallet = wallet;
        this.regDate = regDate;
        this.idnp = idnp;
        this.flat = flat;
    }

    private List<Integer> flat;




    public static PersonDTO from(Person person) {
        final PersonDTO personDTO = new PersonDTO(
//                person.getPersonId(), person.getName(),
//                person.getSurname(), person.getDescription(), person.getPhone(),person.getMobile(),
//                person.getEmail(),person.getWallet(),person.getRegDate(),person.getIdnp()
        );
        personDTO.setPersonId(person.getPersonId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setDescription(person.getDescription());
        personDTO.setPhone(person.getPhone());
        personDTO.setMobile(person.getMobile());
        personDTO.setEmail(person.getEmail());
        personDTO.setWallet(person.getWallet());
        personDTO.setRegDate(person.getRegDate());
        personDTO.setIdnp(person.getIdnp());

        if(person.getFlat() !=null){
            final List<Integer> flatId=person.getFlat().stream()
                    .map(flat -> flat.getFlatid())
                    .collect(Collectors.toList());
            personDTO.setFlat(flatId);
        }
        return personDTO;
    }

    public List<Integer> getFlat() {
        return flat;
    }

    public void setFlat(List<Integer> flat) {
        this.flat = flat;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }
}
