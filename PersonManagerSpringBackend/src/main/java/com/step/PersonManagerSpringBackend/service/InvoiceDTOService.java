package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.*;
import com.step.PersonManagerSpringBackend.model.dto.FlatDTO;
import com.step.PersonManagerSpringBackend.model.dto.InvoiceDTO;
import com.step.PersonManagerSpringBackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceDTOService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private FlatRepository flatRepository;

    public void create(InvoiceDTO dto) throws Exception {
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(dto.getInvoiceNumber());
        invoice.setInvoiceSum(dto.getInvoiceSum());
        invoice.setDateOfPay(dto.getDateOfPay());
        invoice.setEmittedDate(dto.getEmittedDate());
        invoice.setPayTill(dto.getPayTill());
        invoice.setStatus(dto.getStatus());
        invoice.setMeterDataCurrent(dto.getMeterDataCurrent());
        invoice.setUnitPrice(dto.getUnitPrice());

        final Person person = this.personRepository.findById(dto.getPerson()).orElseThrow(() -> new Exception("Cannot link Invoice. Person does not exist."));
        invoice.setPerson(person);
        final Flat flat = this.flatRepository.findById(dto.getFlat()).orElseThrow(() -> new Exception("Cannot link Invoice. Flat does not exist."));
        invoice.setFlat(flat);
        final Supplier supplier = this.supplierRepository.findById(dto.getSupplier()).orElseThrow(() -> new Exception("Cannot link Invoice. Supplier does not exist."));
        invoice.setSupplier(supplier);
        Invoice savedInvoice=this.invoiceRepository.save(invoice);

    }
    public List<InvoiceDTO> getAll() {
        // get all Invoices
        final List<Invoice> all = this.invoiceRepository.findAll(Sort.by(Sort.Direction.ASC, "invoiceid"));
        // convert to DTO
        List<InvoiceDTO> dtos = all.stream().map(invoices -> InvoiceDTO.from(invoices)
        ).collect(Collectors.toList());
        return dtos;
    }
    public InvoiceDTO getById(Integer id) throws Exception {
        final Optional<Invoice> optionalInvoice = this.invoiceRepository.findById(id);
        if(!optionalInvoice.isPresent()){
            throw new Exception("Invoice with id=" + id +" does not exist.");
        }
        final Invoice invoice = optionalInvoice.get();
        return InvoiceDTO.from(invoice);
    }
    public void update(InvoiceDTO invoiceToUpdate) throws Exception{
        final Integer invoiceId = invoiceToUpdate.getInvoiceId();
        Optional<Invoice> optionalInvoice =  this.invoiceRepository.findById(invoiceId);
        if(!optionalInvoice.isPresent()){
            throw new Exception("Invoice with id=" + invoiceId +" does not exist.");
        }
        final Invoice invoice = optionalInvoice.get();
        invoice.setInvoiceNumber(invoiceToUpdate.getInvoiceNumber());
        invoice.setInvoiceSum(invoiceToUpdate.getInvoiceSum());
        invoice.setDateOfPay(invoiceToUpdate.getDateOfPay());
        invoice.setEmittedDate(invoiceToUpdate.getEmittedDate());
        invoice.setPayTill(invoiceToUpdate.getPayTill());
        invoice.setStatus(invoiceToUpdate.getStatus());
        invoice.setMeterDataCurrent(invoiceToUpdate.getMeterDataCurrent());
        invoice.setUnitPrice(invoiceToUpdate.getUnitPrice());

        final Person person = this.personRepository.findById(invoiceToUpdate.getPerson()).orElseThrow(() -> new Exception("Cannot link Invoice. Person does not exist."));
        invoice.setPerson(person);
        final Flat flat = this.flatRepository.findById(invoiceToUpdate.getFlat()).orElseThrow(() -> new Exception("Cannot link Invoice. Flat does not exist."));
        invoice.setFlat(flat);
        final Supplier supplier = this.supplierRepository.findById(invoiceToUpdate.getSupplier()).orElseThrow(() -> new Exception("Cannot link Invoice. Supplier does not exist."));
        invoice.setSupplier(supplier);
        Invoice savedInvoice=this.invoiceRepository.save(invoice);

    }

    public void delete(Integer id) throws Exception {
        Invoice invoice = this.invoiceRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Invoice does not exist"));
        this.invoiceRepository.delete(invoice);
    }
}
