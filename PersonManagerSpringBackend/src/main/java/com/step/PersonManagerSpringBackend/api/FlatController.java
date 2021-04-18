package com.step.PersonManagerSpringBackend.api;

import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.service.FlatService;
import com.step.PersonManagerSpringBackend.service.exception.AddressNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flat")
public class FlatController {
    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private final FlatService flatService;

    @Autowired
    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody FlatDTO flat) {
        try {
            return ResponseEntity.ok(this.flatService.save(flat));
        } catch (EntityNotFoundException | FlatNotFoundException | AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<FlatDTO> allFlats = this.flatService.findAll();
        return ResponseEntity.ok(allFlats);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.flatService.findById(id));
        } catch (FlatNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody FlatDTO flatToUpdate) {
        try {
            return ResponseEntity.ok(this.flatService.update(flatToUpdate));
        } catch (FlatNotFoundException | AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.flatService.delete(id);
            return ResponseEntity.ok("Flat deleted successfully");
        } catch (FlatNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
