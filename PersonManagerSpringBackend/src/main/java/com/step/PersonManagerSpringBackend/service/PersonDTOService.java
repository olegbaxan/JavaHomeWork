package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Person;
import com.step.PersonManagerSpringBackend.model.dto.PersonDTO;
import com.step.PersonManagerSpringBackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonDTOService {
    @Autowired
    private PersonRepository personRepository;

    public void create(PersonDTO dto) throws Exception {
        Person person = new Person();
        person.setName(dto.getName());
        person.setSurname(dto.getSurname());
        person.setDescription(dto.getDescription());
        person.setPhone(dto.getPhone());
        person.setMobile(dto.getMobile());
        person.setIdnp(dto.getIdnp());
        person.setEmail(dto.getEmail());
        person.setWallet(dto.getWallet());
        person.setRegDate(LocalDate.now());
        person.setIdnp(dto.getIdnp());

        Person savedEmployee = this.personRepository.save(person);
    }
    public List<PersonDTO> getAll() {
        // get all persons
        final List<Person> all = this.personRepository.findAll(Sort.by(Sort.Direction.ASC, "personId"));
        // convert to DTO
        List<PersonDTO> dtos = all.stream().map(persons -> PersonDTO.from(persons)
        ).collect(Collectors.toList());
        return dtos;
    }
    public PersonDTO getById(Integer id) throws Exception {
        final Optional<Person> optionalPerson = this.personRepository.findById(id);
        if(!optionalPerson.isPresent()){
            throw new Exception("Person with id=" + id +" does not exist.");
        }
        final Person company = optionalPerson.get();
        return PersonDTO.from(company);
    }
    public void update(PersonDTO personToUpdate) throws Exception{
        final Integer personId = personToUpdate.getPersonId();
        Optional<Person> optionalPerson =  this.personRepository.findById(personId);
        if(!optionalPerson.isPresent()){
            throw new Exception("Person with id=" + personId +" does not exist.");
        }
        final Person person = optionalPerson.get();
        person.setName(personToUpdate.getName());
        person.setSurname(personToUpdate.getSurname());
        person.setDescription(personToUpdate.getDescription());
        person.setPhone(personToUpdate.getPhone());
        person.setMobile(personToUpdate.getMobile());
        person.setIdnp(personToUpdate.getIdnp());
        person.setEmail(personToUpdate.getEmail());
        person.setWallet(personToUpdate.getWallet());
        this.personRepository.save(person);
    }

    public void delete(Integer id) throws Exception {
        Person person = this.personRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Person does not exist"));
        this.personRepository.delete(person);
    }

}
