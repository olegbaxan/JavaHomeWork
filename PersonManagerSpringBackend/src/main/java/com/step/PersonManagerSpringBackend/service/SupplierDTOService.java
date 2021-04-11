package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Address;
import com.step.PersonManagerSpringBackend.model.Supplier;
import com.step.PersonManagerSpringBackend.model.dto.SupplierDTO;
import com.step.PersonManagerSpringBackend.repository.AddressRepository;
import com.step.PersonManagerSpringBackend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierDTOService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void create(SupplierDTO dto) throws Exception {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(dto.getSupplierName());
        supplier.setBankCode(dto.getBankCode());
        supplier.setFiscalCode(dto.getFiscalCode());
        supplier.setIBAN(dto.getIBAN());
        final Address address = this.addressRepository.findById(dto.getAddress()).orElseThrow(() -> new Exception("Cannot link Supplier. Address does not exist."));
        supplier.setAddress(address);
        Supplier savedSupplier=this.supplierRepository.save(supplier);

    }
    public List<SupplierDTO> getAll() {
        // get all suppliers
        final List<Supplier> all = this.supplierRepository.findAll(Sort.by(Sort.Direction.ASC, "supplierId"));
        // convert to DTO
        List<SupplierDTO> dtos = all.stream().map(suppliers -> SupplierDTO.from(suppliers)
        ).collect(Collectors.toList());
        return dtos;
    }
    public SupplierDTO getById(Integer id) throws Exception {
        final Optional<Supplier> optionalSuppliers = this.supplierRepository.findById(id);
        if(!optionalSuppliers.isPresent()){
            throw new Exception("Supplier with id=" + id +" does not exist.");
        }
        final Supplier supplier = optionalSuppliers.get();
        return SupplierDTO.from(supplier);
    }
    public void update(SupplierDTO supplierToUpdate) throws Exception{
        final Integer supplierId = supplierToUpdate.getSupplierId();
        Optional<Supplier> optionalSupplier =  this.supplierRepository.findById(supplierId);
        if(!optionalSupplier.isPresent()){
            throw new Exception("Supplier with id=" + supplierId +" does not exist.");
        }
        final Supplier supplier = optionalSupplier.get();
        supplier.setSupplierName(supplierToUpdate.getSupplierName());
        supplier.setBankCode(supplierToUpdate.getBankCode());
        supplier.setFiscalCode(supplierToUpdate.getFiscalCode());
        supplier.setIBAN(supplierToUpdate.getIBAN());
        final Address address = this.addressRepository.findById(supplierToUpdate.getAddress()).orElseThrow(() -> new Exception("Cannot link Supplier. Address does not exist."));
        supplier.setAddress(address);
        this.supplierRepository.save(supplier);
    }

    public void delete(Integer id) throws Exception {
        Supplier supplier = this.supplierRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Supplier does not exist"));
        this.supplierRepository.delete(supplier);
    }

}
