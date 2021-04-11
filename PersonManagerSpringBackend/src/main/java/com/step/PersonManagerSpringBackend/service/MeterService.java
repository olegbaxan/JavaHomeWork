package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.model.dto.MeterDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.MeterNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeterService {
    private FlatRepository flatRepository;
    private MeterRepository meterRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public MeterService(FlatRepository flatRepository, SupplierRepository supplierRepository, MeterRepository meterRepository) {
        this.flatRepository = flatRepository;
        this.supplierRepository=supplierRepository;
        this.meterRepository = meterRepository;
    }


    public MeterDTO save(MeterDTO meterDTO) throws SupplierNotFoundException, FlatNotFoundException {
        final Meter newMeter = new Meter();
        newMeter.setDestination(meterDTO.getDestination());
        newMeter.setSerial(meterDTO.getSerial());
        newMeter.setInitialValue(meterDTO.getInitialValue());
        newMeter.setCurrentValue(meterDTO.getCurrentValue());
        newMeter.setStatus(meterDTO.getStatus());
        newMeter.setPreviousValue(meterDTO.getPreviousValue());


        Flat linkedFlat = null;
        if (meterDTO.getFlat() != null) {
            linkedFlat = this.flatRepository.findById(meterDTO.getFlat()).
                    orElseThrow(() -> new FlatNotFoundException(meterDTO.getFlat()));
        }
        Supplier linkedSupplier = null;
        if (meterDTO.getSupplier() != null) {
            linkedSupplier = this.supplierRepository.findById(meterDTO.getSupplier()).
                    orElseThrow(() -> new SupplierNotFoundException(meterDTO.getSupplier()));
        }

        newMeter.setFlat(linkedFlat);
        newMeter.setSupplier(linkedSupplier);

        final Meter addMeter = meterRepository.save(newMeter);
        return MeterDTO.from(addMeter);
    }

    public List<MeterDTO> findAll() {
        return meterRepository.findAll().stream().map(meters -> MeterDTO.from(meters)).collect(Collectors.toList());

    }

    public MeterDTO findById(Integer id) throws MeterNotFoundException {
        final Meter meter = meterRepository.findById(id).orElseThrow(() -> new MeterNotFoundException(id));
        return MeterDTO.from(meter);
    }

    public Object update(MeterDTO meterToUpdate) throws FlatNotFoundException, SupplierNotFoundException, MeterNotFoundException {

        final Meter meter = this.meterRepository.findById(meterToUpdate.getMeterId()).orElseThrow(() -> new MeterNotFoundException(meterToUpdate.getMeterId()));
        meter.setDestination(meterToUpdate.getDestination());
        meter.setSerial(meterToUpdate.getSerial());
        meter.setInitialValue(meterToUpdate.getInitialValue());
        meter.setCurrentValue(meterToUpdate.getCurrentValue());
        meter.setStatus(meterToUpdate.getStatus());
        meter.setPreviousValue(meterToUpdate.getPreviousValue());
        Supplier linkedSupplier = null;
        if (meterToUpdate.getSupplier() != null) {
            linkedSupplier = this.supplierRepository.findById(meterToUpdate.getSupplier()).
                    orElseThrow(() -> new SupplierNotFoundException(meterToUpdate.getSupplier()));
        }
        Flat linkedFlat = null;
        if (meterToUpdate.getFlat() != null) {
            linkedFlat = this.flatRepository.findById(meterToUpdate.getFlat()).
                    orElseThrow(() -> new FlatNotFoundException(meterToUpdate.getFlat()));
        }
        meter.setSupplier(linkedSupplier);
        meter.setFlat(linkedFlat);
        final Meter savedMeter = this.meterRepository.save(meter);
        return MeterDTO.from(savedMeter);
    }

    public void delete(Integer id) throws MeterNotFoundException {
        final Meter meter = this.meterRepository.findById(id).orElseThrow(() -> new MeterNotFoundException(id));
        this.meterRepository.delete(meter);
    }
}
