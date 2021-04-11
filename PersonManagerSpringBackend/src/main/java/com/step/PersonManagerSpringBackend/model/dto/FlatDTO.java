package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Flat;

import java.util.List;
import java.util.stream.Collectors;


public class FlatDTO {

    private Integer flatid;
    private byte floor;
    private Integer flatNumber;
    private byte numberOfPerson;
    private String buildLadder;
    private List<Integer> person;
    private Integer address;
    private List<Integer> meters;

    public Integer getFlatid() {
        return flatid;
    }

    public FlatDTO() {

    }

    public FlatDTO(Integer flatid, byte floor, Integer flatNumber, byte numberOfPerson, String buildLadder, List<Integer> person, Integer address, List<Integer> meters) {
        this.flatid = flatid;
        this.floor = floor;
        this.flatNumber = flatNumber;
        this.numberOfPerson = numberOfPerson;
        this.buildLadder = buildLadder;
        this.person = person;
        this.address = address;
        this.meters = meters;
    }

    public static FlatDTO from(Flat flat) {
//         final FlatDTO flatDTO = new FlatDTO(flat.getFlatid(), flat.getFloor(), flat.getFlatNumber(), flat.getNumberOfPerson(), flat.getBuildLadder());
        final FlatDTO flatDTO = new FlatDTO();

        flatDTO.setFlatid(flat.getFlatid());
        flatDTO.setAddress(flat.getAddress().getAddressid());
        flatDTO.setFloor(flat.getFloor());
        flatDTO.setFlatNumber(flat.getFlatNumber());
        flatDTO.setNumberOfPerson(flat.getNumberOfPerson());
        flatDTO.setBuildLadder(flat.getBuildLadder());
        if(flat.getPerson() !=null){
            final List<Integer> pId=flat.getPerson().stream()
                    .map(person -> person.getPersonId())
                    .collect(Collectors.toList());
            flatDTO.setPerson(pId);
        }
        if(flat.getMeter() !=null){
            final List<Integer> mId=flat.getMeter().stream()
                    .map(meter -> meter.getMeterId())
                    .collect(Collectors.toList());
            flatDTO.setPerson(mId);
        }
        return flatDTO;
    }

    public void setFlatid(Integer flatid) {
        this.flatid = flatid;
    }

    public byte getFloor() {
        return floor;
    }

    public void setFloor(byte floor) {
        this.floor = floor;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
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

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public List<Integer> getPerson() {
        return person;
    }

    public void setPerson(List<Integer> person) {
        this.person = person;
    }

    public List<Integer> getMeter() {
        return meters;
    }

    public void setMeter(List<Integer> meters) {
        this.meters = meters;
    }
}
