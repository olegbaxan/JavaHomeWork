package com.step.PersonManagerSpringBackend.api;

import com.step.PersonManagerSpringBackend.model.dto.InvoiceDTO;
import com.step.PersonManagerSpringBackend.service.InvoiceService;
import com.step.PersonManagerSpringBackend.service.exception.FlatNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.InvoiceNotFoundException;
import com.step.PersonManagerSpringBackend.service.exception.PersonNotFoundException;
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
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody InvoiceDTO invoice) {
        try {
            return ResponseEntity.ok(this.invoiceService.save(invoice));
        } catch (EntityNotFoundException | SupplierNotFoundException | FlatNotFoundException|PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity getAll() {
        log.info("");
        final List<InvoiceDTO> allInvoices = this.invoiceService.findAll();
        return ResponseEntity.ok(allInvoices);
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(this.invoiceService.findById(id));
        } catch (InvoiceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody InvoiceDTO invoiceToUpdate) {
        try {
            return ResponseEntity.ok(this.invoiceService.update(invoiceToUpdate));
        } catch (PersonNotFoundException|SupplierNotFoundException|FlatNotFoundException|InvoiceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        try {
            this.invoiceService.delete(id);
            return ResponseEntity.ok("Invoice deleted successfully");
        } catch (InvoiceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
