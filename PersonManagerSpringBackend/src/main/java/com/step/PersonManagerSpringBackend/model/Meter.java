package com.step.PersonManagerSpringBackend.model;

import javax.persistence.*;

@Entity
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meterId;
    @Column(length = 15)
    private String destination;
    @Column(length = 10)
    private String serial;
    private Integer initialValue;
    private Integer previousValue;
    private Integer currentValue;
    @Column(length = 10)
    private String status;

    @OneToOne
    private Supplier supplier;
    @ManyToOne
    private Flat flat;

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Integer getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(Integer previousValue) {
        this.previousValue = previousValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }


}