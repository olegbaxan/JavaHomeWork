package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Meter;
import com.step.PersonManagerSpringBackend.model.Supplier;
import com.step.PersonManagerSpringBackend.model.dto.MeterDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MeterDTOService {
    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private MeterRepository meterRepository;

    public void create(MeterDTO dto) throws Exception {
        Meter meter = new Meter();
        meter.setDestination(dto.getDestination());
        meter.setSerial(dto.getSerial());
        meter.setInitialValue(dto.getInitialValue());
        meter.setCurrentValue(dto.getCurrentValue());
        meter.setStatus(dto.getStatus());
        meter.setPreviousValue(dto.getPreviousValue());
        final Supplier supplier = this.supplierRepository.findById(dto.getSupplier()).orElseThrow(() -> new Exception("Cannot link Meter. Supplier does not exist."));
        meter.setSupplier(supplier);
        final Flat flat = this.flatRepository.findById(dto.getFlat()).orElseThrow(() -> new Exception("Cannot link Meter. Flat does not exist."));
        meter.setFlat(flat);
        Meter savedMeter=this.meterRepository.save(meter);

    }
    public List<MeterDTO> getAll() {
        // get all meters
        final List<Meter> all = this.meterRepository.findAll(Sort.by(Sort.Direction.ASC, "meterid"));
        // convert to DTO
        List<MeterDTO> dtos = all.stream().map(meters -> MeterDTO.from(meters)
        ).collect(Collectors.toList());
        return dtos;
    }
    public MeterDTO getById(Integer id) throws Exception {
        final Optional<Meter> optionalMeter = this.meterRepository.findById(id);
        if(!optionalMeter.isPresent()){
            throw new Exception("Meter with id=" + id +" does not exist.");
        }
        final Meter meter = optionalMeter.get();
        return MeterDTO.from(meter);
    }
    public void update(MeterDTO meterToUpdate) throws Exception{
        final Integer meterId = meterToUpdate.getMeterId();
        Optional<Meter> optionalMeter =  this.meterRepository.findById(meterId);
        if(!optionalMeter.isPresent()){
            throw new Exception("Meter with id=" + meterId +" does not exist.");
        }
        final Meter meter = optionalMeter.get();
        meter.setDestination(meterToUpdate.getDestination());
        meter.setSerial(meterToUpdate.getSerial());
        meter.setInitialValue(meterToUpdate.getInitialValue());
        meter.setCurrentValue(meterToUpdate.getCurrentValue());
        meter.setStatus(meterToUpdate.getStatus());
        meter.setPreviousValue(meterToUpdate.getPreviousValue());
        final Supplier supplier = this.supplierRepository.findById(meterToUpdate.getSupplier()).orElseThrow(() -> new Exception("Cannot link Meter. Supplier does not exist."));
        meter.setSupplier(supplier);
        final Flat flat = this.flatRepository.findById(meterToUpdate.getFlat()).orElseThrow(() -> new Exception("Cannot link Meter. Flat does not exist."));
        meter.setFlat(flat);
        this.meterRepository.save(meter);
    }

    public void delete(Integer id) throws Exception {
        Meter meter = this.meterRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Meter does not exist"));
        this.meterRepository.delete(meter);
    }
}
