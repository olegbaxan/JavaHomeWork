package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlatDTOService {
    @Autowired
    private FlatRepository flatRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private MeterRepository meterRepository;


    public void create(FlatDTO dto) throws Exception {
        Flat flat = new Flat();
        flat.setFlatNumber(dto.getFlatNumber());
        flat.setFloor(dto.getFloor());
        flat.setBuildLadder(dto.getBuildLadder());
        flat.setNumberOfPerson(dto.getNumberOfPerson());
        final Address address = this.addressRepository.findById(dto.getAddress()).orElseThrow(() -> new Exception("Cannot link Flat. Address does not exist."));
        flat.setAddress(address);
//        final List<Person> person = this.personRepository.findById(dto.getPerson().get()).orElseThrow(() -> new Exception("Cannot link Flat. Person does not exist."));
//        flat.setPerson(person);
//        final List<Meter> meter = this.meterRepository.findById(dto.getMeter()).orElseThrow(() -> new Exception("Cannot link Flat. Meter does not exist."));
//        flat.setMeter(meter);
        Flat savedFlat=this.flatRepository.save(flat);

    }
    public List<FlatDTO> getAll() {
        // get all flats
        final List<Flat> all = this.flatRepository.findAll(Sort.by(Sort.Direction.ASC, "flatid"));
        // convert to DTO
        List<FlatDTO> dtos = all.stream().map(flats -> FlatDTO.from(flats)
        ).collect(Collectors.toList());
        return dtos;
    }
    public FlatDTO getById(Integer id) throws Exception {
        final Optional<Flat> optionalFlat = this.flatRepository.findById(id);
        if(!optionalFlat.isPresent()){
            throw new Exception("Flat with id=" + id +" does not exist.");
        }
        final Flat flat = optionalFlat.get();
        return FlatDTO.from(flat);
    }
    public void update(FlatDTO flatToUpdate) throws Exception{
        final Integer flatId = flatToUpdate.getFlatid();
        Optional<Flat> optionalFlat =  this.flatRepository.findById(flatId);
        if(!optionalFlat.isPresent()){
            throw new Exception("Flat with id=" + flatId +" does not exist.");
        }
        final Flat flat = optionalFlat.get();
        flat.setFlatNumber(flatToUpdate.getFlatNumber());
        flat.setFloor(flatToUpdate.getFloor());
        flat.setBuildLadder(flatToUpdate.getBuildLadder());
        flat.setNumberOfPerson(flatToUpdate.getNumberOfPerson());
        final Address address = this.addressRepository.findById(flatToUpdate.getAddress()).orElseThrow(() -> new Exception("Cannot link Flat. Address does not exist."));
        flat.setAddress(address);
//        final List<Person> person = this.personRepository.findById(flatToUpdate.getPerson()).orElseThrow(() -> new Exception("Cannot link Flat. Person does not exist."));
//        flat.setPerson(person);
//        final List<Meter> meter = this.meterRepository.findById(flatToUpdate.getMeter()).orElseThrow(() -> new Exception("Cannot link Flat. Meter does not exist."));
//        flat.setMeter(meter);
        this.flatRepository.save(flat);
    }

    public void delete(Integer id) throws Exception {
        Flat flat = this.flatRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Flat does not exist"));
        this.flatRepository.delete(flat);
    }


}
