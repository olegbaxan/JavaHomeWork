package com.step.PersonManagerSpringBackend.api;

import com.step.PersonManagerSpringBackend.model.dto.SupplierDTO;
import com.step.PersonManagerSpringBackend.service.SupplierService;
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
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SupplierDTO supplier) {
        try {
            return ResponseEntity.ok(this.supplierService.save(supplier));
        } catch (EntityNotFoundException | SupplierNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<SupplierDTO> allSuppliers = this.supplierService.findAll();
        return ResponseEntity.ok(allSuppliers);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.supplierService.findById(id));
        } catch (SupplierNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody SupplierDTO supplierToUpdate) {
        try {
            return ResponseEntity.ok(this.supplierService.update(supplierToUpdate));
        } catch (SupplierNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.supplierService.delete(id);
            return ResponseEntity.ok("Supplier deleted successfully");
        } catch (SupplierNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
