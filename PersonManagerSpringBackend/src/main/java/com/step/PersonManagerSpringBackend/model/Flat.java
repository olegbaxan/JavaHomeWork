package com.step.PersonManagerSpringBackend.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flatid;
    private byte floor;
    private Integer flatNumber;
    private byte numberOfPerson;
    @Column(length = 5)
    private String buildLadder;

    @ManyToMany
    private List<Person> persons ;
    @ManyToOne
    private Address address;
//    @OneToMany
//    private List<Meter> meters;

    public Integer getFlatid() {
        return flatid;
    }

    public void setFlatid(int flatid) {
        this.flatid = flatid;
    }

    public byte getFloor() {
        return floor;
    }

    public void setFloor(byte floor) {
        this.floor = floor;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public byte getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(byte numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getBuildLadder() {
        return buildLadder;
    }

    public void setBuildLadder(String buildLadder) {
        this.buildLadder = buildLadder;
    }

    public void setFlatid(Integer flatid) {
        this.flatid = flatid;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public List<Person> getPerson() {
        return persons;
    }

    public void setPerson(List<Person> persons) {
        this.persons = persons;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Meter> getMeter() {
//        return meters;
//    }
//
//    public void setMeter(List<Meter> meters) {
//        this.meters = meters;
//    }
}
