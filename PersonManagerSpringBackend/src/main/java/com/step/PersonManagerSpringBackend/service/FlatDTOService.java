package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
//    @Autowired
//    private MeterRepository meterRepository;


    public void create(FlatDTO dto) throws Exception {
        Flat flat = new Flat();
        System.out.println("Into FlatDTOService");
        flat.setFlatNumber(dto.getFlatNumber());
        flat.setFloor(dto.getFloor());
        flat.setBuildLadder(dto.getBuildLadder());
        flat.setNumberOfPerson(dto.getNumberOfPerson());
        final Address address = this.addressRepository.findById(dto.getAddress()).orElseThrow(() -> new Exception("Cannot link Flat. Address does not exist."));
        flat.setAddress(address);
         //persons = new ArrayList<>();
        List<Person> persons=this.personRepository.findByPersonIdIsIn(dto.getPerson());
        System.out.println("FlatDTO create "+ dto.getPerson());
         //meters = new ArrayList<>();
//        List<Meter> meters=this.meterRepository.findByMeterIdIsIn(dto.getMeter());
//        System.out.println("FlatDTO create "+ dto.getMeter());
        flat.setPerson(persons);
        for(int i=0;i<persons.size();i++){
            if(!persons.get(i).getFlat().equals(dto.getFlatid())){
                persons.get(i).getFlat().add(flat);
            }
        }
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
         //person = new ArrayList<>();
        List<Person> person=this.personRepository.findByPersonIdIsIn(flatToUpdate.getPerson());
        flat.setPerson(person);
        for(int i=0;i<person.size();i++){
            if(!person.get(i).getFlat().equals(flatToUpdate.getFlatid())){
                person.get(i).getFlat().add(flat);
            }
        }
        this.flatRepository.save(flat);
    }

    public void delete(Integer id) throws Exception {
        Flat flat = this.flatRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Flat does not exist"));
//        List<Person> personToDeleteFlat = null;
//        personToDeleteFlat=this.personRepository.findPersonByFlat(flat);
//        for(int i=0;i<personToDeleteFlat.size();i++){
//            personToDeleteFlat.get(i).getFlat().remove(flat);
//        }
        this.flatRepository.delete(flat);
    }


}
