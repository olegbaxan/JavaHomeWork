package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Person;
import com.step.PersonManagerSpringBackend.model.dto.PersonDTO;
import com.step.PersonManagerSpringBackend.repository.FlatRepository;
import com.step.PersonManagerSpringBackend.repository.PersonRepository;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private PersonRepository personRepository;
    private FlatRepository flatRepository;
@Autowired
public PersonService(PersonRepository personRepository, FlatRepository flatRepository) {
    this.personRepository = personRepository;
    this.flatRepository=flatRepository;
}


    public PersonDTO save(PersonDTO personDTO) throws PersonNotFoundException, FlatNotFoundException {
        final Person newPerson = new Person();
        newPerson.setPersonId(personDTO.getPersonId());
        newPerson.setName(personDTO.getName());
        newPerson.setSurname(personDTO.getSurname());
        newPerson.setDescription(personDTO.getDescription());
        newPerson.setPhone(personDTO.getPhone());
        newPerson.setMobile(personDTO.getMobile());
        newPerson.setIdnp(personDTO.getIdnp());
        newPerson.setEmail(personDTO.getEmail());
        newPerson.setWallet(personDTO.getWallet());
        newPerson.setRegDate(LocalDate.now());
        List<Flat> linkedFlat = null;
        if (personDTO.getFlat() != null) {
            linkedFlat=this.flatRepository.findFlatsByFlatidIsIn(personDTO.getFlat());

            newPerson.setFlat(linkedFlat);
        }
        final Person addPerson = personRepository.save(newPerson);


        return PersonDTO.from(addPerson);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(persons -> PersonDTO.from(persons)).collect(Collectors.toList());

    }
    public PersonDTO findById(Integer id) throws PersonNotFoundException {
        final Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return PersonDTO.from(person);
    }

    public Object update(PersonDTO personToUpdate) throws PersonNotFoundException {
        final Person person = this.personRepository.findById(personToUpdate.getPersonId()).orElseThrow(() -> new PersonNotFoundException(personToUpdate.getPersonId()));
        person.setName(personToUpdate.getName());
        person.setSurname(personToUpdate.getSurname());
        person.setDescription(personToUpdate.getDescription());
        person.setPhone(personToUpdate.getPhone());
        person.setMobile(personToUpdate.getMobile());
        person.setIdnp(personToUpdate.getIdnp());
        person.setEmail(personToUpdate.getEmail());
        person.setWallet(personToUpdate.getWallet());
        List<Flat> linkedFlat = null;
        if (personToUpdate.getFlat() != null) {
            linkedFlat = this.flatRepository.findFlatsByFlatidIsIn(personToUpdate.getFlat());
            person.setFlat(linkedFlat);
        }
        final Person savedPerson = this.personRepository.save(person);
        return PersonDTO.from(savedPerson);
    }

    public void delete(Integer id) throws PersonNotFoundException{
        final Person person = this.personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        List<Flat> flatToDeletePerson = null;
        flatToDeletePerson=this.flatRepository.findFlatByPersons(person);
        for(int i=0;i<flatToDeletePerson.size();i++){
            flatToDeletePerson.get(i).getPerson().remove(person);
        }

        this.personRepository.delete(person);
    }
}
