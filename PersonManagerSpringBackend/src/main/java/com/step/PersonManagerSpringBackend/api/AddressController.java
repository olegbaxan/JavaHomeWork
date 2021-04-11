package com.step.PersonManagerSpringBackend.api;

import com.step.PersonManagerSpringBackend.model.dto.AddressDTO;
import com.step.PersonManagerSpringBackend.service.AddressService;
import com.step.PersonManagerSpringBackend.service.exception.AddressNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.SupplierNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody AddressDTO address) {
        try {
            return ResponseEntity.ok(this.addressService.save(address));
        } catch (EntityNotFoundException | AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<AddressDTO> allAddresses = this.addressService.findAll();
        return ResponseEntity.ok(allAddresses);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.addressService.findById(id));
        } catch (AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody AddressDTO addressToUpdate) {
        try {
            return ResponseEntity.ok(this.addressService.update(addressToUpdate));
        } catch (AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.addressService.delete(id);
            return ResponseEntity.ok("Address deleted successfully");
        } catch (AddressNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
