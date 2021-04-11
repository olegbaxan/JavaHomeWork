package com.step.PersonManagerSpringBackend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    @Column(length = 20)
    private String invoiceNumber;
    @Column(length = 10)
    private String status;
    private Integer meterDataCurrent;
    private Integer meterDataPrevious;
    private double invoiceSum;
    private double unitPrice;
    private LocalDate payTill;
    private LocalDate emittedDate;
    private LocalDate dateOfPay;

    @ManyToOne
    private Supplier supplier;
    @OneToOne
    private Person person;
    @OneToOne
    private Flat flat;



    public LocalDate getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(LocalDate dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMeterDataCurrent() {
        return meterDataCurrent;
    }

    public void setMeterDataCurrent(Integer meterDataCurrent) {
        this.meterDataCurrent = meterDataCurrent;
    }

    public Integer getMeterDataPrevious() {
        return meterDataPrevious;
    }

    public void setMeterDataPrevious(Integer meterDataPrevious) {
        this.meterDataPrevious = meterDataPrevious;
    }

    public double getInvoiceSum() {
        return invoiceSum;
    }

    public void setInvoiceSum(double invoiceSum) {
        this.invoiceSum = invoiceSum;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getPayTill() {
        return payTill;
    }

    public void setPayTill(LocalDate payTill) {
        this.payTill = payTill;
    }

    public LocalDate getEmittedDate() {
        return emittedDate;
    }

    public void setEmittedDate(LocalDate emittedDate) {
        this.emittedDate = emittedDate;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
