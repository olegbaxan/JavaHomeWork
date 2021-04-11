package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Invoice;
import com.step.PersonManagerSpringBackend.model.Person;
import com.step.PersonManagerSpringBackend.model.Supplier;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class InvoiceDTO {

    private Integer invoiceId;
    private String invoiceNumber;
    private String status;
    private Integer meterDataCurrent;
    private Integer meterDataPrevious;
    private double invoiceSum;
    private double unitPrice;
    private LocalDate payTill;
    private LocalDate emittedDate;
    private LocalDate dateOfPay;
    private Integer supplier;
    private Integer person;
    private Integer flat;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Integer invoiceId, String invoiceNumber, String status, Integer meterDataCurrent, Integer meterDataPrevious, double invoiceSum, double unitPrice, LocalDate payTill, LocalDate emittedDate, LocalDate dateOfPay) {
        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.status = status;
        this.meterDataCurrent = meterDataCurrent;
        this.meterDataPrevious = meterDataPrevious;
        this.invoiceSum = invoiceSum;
        this.unitPrice = unitPrice;
        this.payTill = payTill;
        this.emittedDate = emittedDate;
        this.dateOfPay = dateOfPay;
//        this.supplier = supplier;
//        this.person = person;
//        this.flat = flat;
    }
    public static InvoiceDTO from(Invoice invoice) {
        final InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getInvoiceId(), invoice.getInvoiceNumber(), invoice.getStatus(),
                invoice.getMeterDataCurrent(), invoice.getMeterDataPrevious(),invoice.getInvoiceSum(),invoice.getUnitPrice()
        ,invoice.getPayTill(),invoice.getEmittedDate(),invoice.getDateOfPay());
        if(invoice.getSupplier() != null){
            invoiceDTO.setSupplier(invoice.getSupplier().getSupplierId());
        }
        if(invoice.getPerson() != null){
            invoiceDTO.setPerson(invoice.getPerson().getPersonId());
        }
        if(invoice.getFlat() != null){
            invoiceDTO.setFlat(invoice.getFlat().getFlatid());
        }
        return invoiceDTO;
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

    public LocalDate getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(LocalDate dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }
}
