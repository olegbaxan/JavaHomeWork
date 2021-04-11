package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Address;
import com.step.PersonManagerSpringBackend.model.Supplier;

import javax.persistence.OneToOne;

public class SupplierDTO {


    private Integer supplierId;
    private String supplierName;
    private String IBAN;
    private String fiscalCode;
    private String bankCode;
    private Integer address;

    public SupplierDTO() {

    }

    public SupplierDTO(Integer supplierId, String supplierName, String IBAN, String fiscalCode, String bankCode) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.IBAN = IBAN;
        this.fiscalCode = fiscalCode;
        this.bankCode = bankCode;

    }

    public static SupplierDTO from(Supplier supplier) {
        final SupplierDTO supplierDTO = new SupplierDTO(supplier.getSupplierId(), supplier.getSupplierName(), supplier.getIBAN(),
                supplier.getFiscalCode(), supplier.getBankCode());
        if(supplier.getAddress() != null){
            supplierDTO.setAddress(supplier.getAddress().getAddressid());
        }
        return supplierDTO;
    }
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }
}
