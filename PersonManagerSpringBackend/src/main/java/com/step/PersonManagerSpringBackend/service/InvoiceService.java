package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.InvoiceDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import com.step.PersonManagerSpringBackend.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private FlatRepository flatRepository;
    private PersonRepository personRepository;
    private SupplierRepository supplierRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(FlatRepository flatRepository, SupplierRepository supplierRepository, PersonRepository personRepository,InvoiceRepository invoiceRepository) {
        this.flatRepository = flatRepository;
        this.supplierRepository=supplierRepository;
        this.personRepository = personRepository;
        this.invoiceRepository=invoiceRepository;
    }


    public InvoiceDTO save(InvoiceDTO invoiceDTO) throws SupplierNotFoundException, FlatNotFoundException, PersonNotFoundException {
        final Invoice newInvoice = new Invoice();
        newInvoice.setInvoiceNumber(invoiceDTO.getInvoiceNumber());
        newInvoice.setInvoiceSum(invoiceDTO.getInvoiceSum());
        newInvoice.setDateOfPay(invoiceDTO.getDateOfPay());
        newInvoice.setEmittedDate(invoiceDTO.getEmittedDate());
        newInvoice.setPayTill(invoiceDTO.getPayTill());
        newInvoice.setStatus(invoiceDTO.getStatus());
        newInvoice.setMeterDataCurrent(invoiceDTO.getMeterDataCurrent());
        newInvoice.setUnitPrice(invoiceDTO.getUnitPrice());


        Flat linkedFlat = null;
        if (invoiceDTO.getFlat() != null) {
            linkedFlat = this.flatRepository.findById(invoiceDTO.getFlat()).
                    orElseThrow(() -> new FlatNotFoundException(invoiceDTO.getFlat()));
        }
        Supplier linkedSupplier = null;
        if (invoiceDTO.getSupplier() != null) {
            linkedSupplier = this.supplierRepository.findById(invoiceDTO.getSupplier()).
                    orElseThrow(() -> new SupplierNotFoundException(invoiceDTO.getSupplier()));
        }
        Person linkedPerson = null;
        if (invoiceDTO.getPerson() != null) {
            linkedPerson = this.personRepository.findById(invoiceDTO.getPerson()).
                    orElseThrow(() -> new PersonNotFoundException(invoiceDTO.getPerson()));
        }

        newInvoice.setFlat(linkedFlat);
        newInvoice.setSupplier(linkedSupplier);
        newInvoice.setPerson(linkedPerson);

        final Invoice addInvoice = invoiceRepository.save(newInvoice);
        return InvoiceDTO.from(addInvoice);
    }

    public List<InvoiceDTO> findAll() {
        return invoiceRepository.findAll().stream().map(invoices -> InvoiceDTO.from(invoices)).collect(Collectors.toList());

    }

    public InvoiceDTO findById(Integer id) throws InvoiceNotFoundException, InvoiceNotFoundException {
        final Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        return InvoiceDTO.from(invoice);
    }

    public Object update(InvoiceDTO invoiceToUpdate) throws InvoiceNotFoundException, FlatNotFoundException, SupplierNotFoundException, PersonNotFoundException {

        final Invoice invoice = this.invoiceRepository.findById(invoiceToUpdate.getInvoiceId()).orElseThrow(() -> new InvoiceNotFoundException(invoiceToUpdate.getInvoiceId()));
        invoice.setInvoiceNumber(invoiceToUpdate.getInvoiceNumber());
        invoice.setInvoiceSum(invoiceToUpdate.getInvoiceSum());
        invoice.setDateOfPay(invoiceToUpdate.getDateOfPay());
        invoice.setEmittedDate(invoiceToUpdate.getEmittedDate());
        invoice.setPayTill(invoiceToUpdate.getPayTill());
        invoice.setStatus(invoiceToUpdate.getStatus());
        invoice.setMeterDataCurrent(invoiceToUpdate.getMeterDataCurrent());
        invoice.setUnitPrice(invoiceToUpdate.getUnitPrice());
        Supplier linkedSupplier = null;
        if (invoiceToUpdate.getSupplier() != null) {
            linkedSupplier = this.supplierRepository.findById(invoiceToUpdate.getSupplier()).
                    orElseThrow(() -> new SupplierNotFoundException(invoiceToUpdate.getSupplier()));
        }
        Flat linkedFlat = null;
        if (invoiceToUpdate.getFlat() != null) {
            linkedFlat = this.flatRepository.findById(invoiceToUpdate.getFlat()).
                    orElseThrow(() -> new FlatNotFoundException(invoiceToUpdate.getFlat()));
        }
        Person linkedPerson = null;
        if (invoiceToUpdate.getPerson() != null) {
            linkedPerson = this.personRepository.findById(invoiceToUpdate.getPerson()).
                    orElseThrow(() -> new PersonNotFoundException(invoiceToUpdate.getPerson()));
        }
        invoice.setSupplier(linkedSupplier);
        invoice.setFlat(linkedFlat);
        invoice.setPerson(linkedPerson);
        final Invoice savedInvoice = this.invoiceRepository.save(invoice);
        return InvoiceDTO.from(savedInvoice);
    }

    public void delete(Integer id) throws InvoiceNotFoundException {
        final Invoice invoice = this.invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
        this.invoiceRepository.delete(invoice);
    }
}
