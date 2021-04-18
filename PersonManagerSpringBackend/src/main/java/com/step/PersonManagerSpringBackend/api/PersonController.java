package com.step.PersonManagerSpringBackend.api;


import com.step.PersonManagerSpringBackend.model.dto.PersonDTO;
import com.step.PersonManagerSpringBackend.service.PersonService;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PersonDTO person) {
        try {
            return ResponseEntity.ok(this.personService.save(person));
        } catch (EntityNotFoundException | PersonNotFoundException | FlatNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<PersonDTO> allPersons = this.personService.findAll();
        return ResponseEntity.ok(allPersons);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.personService.findById(id));
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody PersonDTO personToUpdate) {
        try {
            return ResponseEntity.ok(this.personService.update(personToUpdate));
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.personService.delete(id);
            return ResponseEntity.ok("Person deleted successfully");
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
