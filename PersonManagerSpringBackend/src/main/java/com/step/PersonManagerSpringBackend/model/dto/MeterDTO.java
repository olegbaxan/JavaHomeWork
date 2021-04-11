package com.step.PersonManagerSpringBackend.model.dto;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Meter;
import com.step.PersonManagerSpringBackend.model.Supplier;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class MeterDTO {

    private Integer meterId;
    private String destination;
    private String serial;
    private Integer initialValue;
    private Integer previousValue;
    private Integer currentValue;
    private String status;
    private Integer supplier;
    private Integer flat;

    public MeterDTO() {

    }

    public MeterDTO(Integer meterId, String destination, String serial, Integer initialValue, Integer previousValue, Integer currentValue, String status) {
        this.meterId = meterId;
        this.destination = destination;
        this.serial = serial;
        this.initialValue = initialValue;
        this.previousValue = previousValue;
        this.currentValue = currentValue;
        this.status = status;

    }

    public static MeterDTO from(Meter meter) {
        final MeterDTO meterDTO = new MeterDTO(meter.getMeterId(), meter.getDestination(), meter.getSerial(), meter.getInitialValue(),
                meter.getPreviousValue(),meter.getCurrentValue(),meter.getStatus());
        if(meter.getFlat() != null){
            meterDTO.setFlat(meter.getFlat().getFlatid());
        }
        if(meter.getSupplier() != null){
            meterDTO.setSupplier(meter.getSupplier().getSupplierId());
        }
        return meterDTO;
    }


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

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }
}
