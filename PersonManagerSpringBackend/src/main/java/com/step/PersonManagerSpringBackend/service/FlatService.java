package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.repository.AddressRepository;
import com.step.PersonManagerSpringBackend.repository.FlatRepository;
import com.step.PersonManagerSpringBackend.repository.PersonRepository;
import com.step.PersonManagerSpringBackend.service.exception.AddressNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatService {
    private FlatRepository flatRepository;
    private PersonRepository personRepository;
    private AddressRepository addressRepository;
//    private MeterRepository meterRepository;

    @Autowired
    public FlatService(FlatRepository flatRepository, PersonRepository personRepository, AddressRepository addressRepository) {
        this.flatRepository = flatRepository;
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
//        this.meterRepository = meterRepository;
    }


    public FlatDTO save(FlatDTO flatDTO) throws FlatNotFoundException, AddressNotFoundException {
        final Flat newFlat = new Flat();
        newFlat.setFlatNumber(flatDTO.getFlatNumber());
        newFlat.setFloor(flatDTO.getFloor());
        newFlat.setBuildLadder(flatDTO.getBuildLadder());
        newFlat.setNumberOfPerson(flatDTO.getNumberOfPerson());
        Address linkedAddress = null;
        if (flatDTO.getAddress() != null) {
            linkedAddress = this.addressRepository.findById(flatDTO.getAddress()).
                    orElseThrow(() -> new AddressNotFoundException(flatDTO.getAddress()));
        }

        List<Person> linkedPerson = null;
        if (flatDTO.getPerson() != null) {
            System.out.println("Person create "+ flatDTO.getPerson());
                linkedPerson = this.personRepository.findByPersonIdIsIn(flatDTO.getPerson());
        }
        for(int i=0;i<linkedPerson.size();i++){
            if(!linkedPerson.get(i).getFlat().equals(flatDTO.getFlatid())){
                linkedPerson.get(i).getFlat().add(newFlat);
            }
        }
        newFlat.setAddress(linkedAddress);
        newFlat.setPerson(linkedPerson);
//        newFlat.setMeter(linkedMeter);
        final Flat addFlat = flatRepository.save(newFlat);
        return FlatDTO.from(addFlat);
    }

    public List<FlatDTO> findAll() {
        return flatRepository.findAll().stream().map(flats -> FlatDTO.from(flats)).collect(Collectors.toList());

    }

    public FlatDTO findById(Integer id) throws FlatNotFoundException {
        final Flat flat = flatRepository.findById(id).orElseThrow(() -> new FlatNotFoundException(id));
        return FlatDTO.from(flat);
    }

    public Object update(FlatDTO flatToUpdate) throws FlatNotFoundException, AddressNotFoundException {

        final Flat flat = this.flatRepository.findById(flatToUpdate.getFlatid()).orElseThrow(() -> new FlatNotFoundException(flatToUpdate.getFlatid()));
        flat.setFlatNumber(flatToUpdate.getFlatNumber());
        flat.setFloor(flatToUpdate.getFloor());
        flat.setBuildLadder(flatToUpdate.getBuildLadder());
        flat.setNumberOfPerson(flatToUpdate.getNumberOfPerson());
        Address linkedAddress = null;
        if (flatToUpdate.getAddress() != null) {
            linkedAddress = this.addressRepository.findById(flatToUpdate.getAddress()).
                    orElseThrow(() -> new AddressNotFoundException(flatToUpdate.getAddress()));
        }
        List<Person> linkedPerson = null;
        if (flatToUpdate.getPerson() != null) {
            System.out.println("Person update "+ flatToUpdate.getPerson());
            linkedPerson = this.personRepository.findByPersonIdIsIn(flatToUpdate.getPerson());
        }

        for(int i=0;i<linkedPerson.size();i++){
            if(!linkedPerson.get(i).getFlat().equals(flatToUpdate.getFlatid())){
                linkedPerson.get(i).getFlat().add(flat);
            }
        }
        flat.setAddress(linkedAddress);
        flat.setPerson(linkedPerson);
//        flat.setMeter(linkedMeter);
        final Flat savedFlat = this.flatRepository.save(flat);
        return FlatDTO.from(savedFlat);
    }

    public void delete(Integer id) throws FlatNotFoundException {
        final Flat flat = this.flatRepository.findById(id).orElseThrow(() -> new FlatNotFoundException(id));
        System.out.println("Flat");

        List<Person> personToDeleteFlat = null;
        personToDeleteFlat=this.personRepository.findPersonByFlat(flat);
        for(int i=0;i<personToDeleteFlat.size();i++){
            personToDeleteFlat.get(i).getFlat().remove(flat);
        }
        this.flatRepository.delete(flat);
    }
}
