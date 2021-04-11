package com.step.PersonManagerSpringBackend.api;

import com.step.PersonManagerSpringBackend.model.dto.MeterDTO;
import com.step.PersonManagerSpringBackend.service.MeterService;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.MeterNotFoundException;
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
@RequestMapping("/api/v1/meter")
public class MeterController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private final MeterService meterService;

    @Autowired
    public MeterController(MeterService meterService) {
        this.meterService = meterService;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody MeterDTO meter) {
        try {
            return ResponseEntity.ok(this.meterService.save(meter));
        } catch (EntityNotFoundException | SupplierNotFoundException| FlatNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<MeterDTO> allMeters = this.meterService.findAll();
        return ResponseEntity.ok(allMeters);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.meterService.findById(id));
        } catch (MeterNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody MeterDTO meterToUpdate) {
        try {
            return ResponseEntity.ok(this.meterService.update(meterToUpdate));
        } catch (MeterNotFoundException | FlatNotFoundException | SupplierNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.meterService.delete(id);
            return ResponseEntity.ok("Meter deleted successfully");
        } catch (MeterNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}
