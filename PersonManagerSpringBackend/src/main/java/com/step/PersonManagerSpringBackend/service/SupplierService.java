package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Address;
import com.step.PersonManagerSpringBackend.model.Supplier;
import com.step.PersonManagerSpringBackend.model.dto.SupplierDTO;
import com.step.PersonManagerSpringBackend.repository.AddressRepository;
import com.step.PersonManagerSpringBackend.repository.SupplierRepository;
import com.step.PersonManagerSpringBackend.service.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;
    private AddressRepository addressRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository, AddressRepository addressRepository) {
        this.supplierRepository = supplierRepository;
        this.addressRepository = addressRepository;
    }


    public SupplierDTO save(SupplierDTO supplierDTO) throws SupplierNotFoundException {
        final Supplier newSupplier = new Supplier();
        newSupplier.setSupplierName(supplierDTO.getSupplierName());
        newSupplier.setBankCode(supplierDTO.getBankCode());
        newSupplier.setIBAN(supplierDTO.getIBAN());
        newSupplier.setFiscalCode(supplierDTO.getFiscalCode());
        Address linkedAddress = null;
        if (supplierDTO.getAddress() != null) {
            linkedAddress = this.addressRepository.findById(supplierDTO.getAddress()).
                    orElseThrow(() -> new SupplierNotFoundException(supplierDTO.getAddress()));
        }
        newSupplier.setAddress(linkedAddress);

        final Supplier addSupplier = supplierRepository.save(newSupplier);
        return SupplierDTO.from(addSupplier);
    }

    public List<SupplierDTO> findAll() {
        return supplierRepository.findAll().stream().map(suppliers -> SupplierDTO.from(suppliers)).collect(Collectors.toList());

    }

    public SupplierDTO findById(Integer id) throws SupplierNotFoundException {
        final Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));
        return SupplierDTO.from(supplier);
    }

    public Object update(SupplierDTO supplierToUpdate) throws SupplierNotFoundException {

        final Supplier supplier = this.supplierRepository.findById(supplierToUpdate.getSupplierId()).orElseThrow(() -> new SupplierNotFoundException(supplierToUpdate.getSupplierId()));
        supplier.setSupplierName(supplierToUpdate.getSupplierName());
        supplier.setIBAN(supplierToUpdate.getIBAN());
        supplier.setFiscalCode(supplierToUpdate.getFiscalCode());
        supplier.setBankCode(supplierToUpdate.getBankCode());
        Address linkedAddress = null;
        if (supplierToUpdate.getAddress() != null) {
            linkedAddress = this.addressRepository.findById(supplierToUpdate.getAddress()).
                    orElseThrow(() -> new SupplierNotFoundException(supplierToUpdate.getAddress()));
        }
        supplier.setAddress(linkedAddress);
        final Supplier savedSupplier = this.supplierRepository.save(supplier);
        return SupplierDTO.from(savedSupplier);
    }

    public void delete(Integer id) throws SupplierNotFoundException {
        final Supplier supplier = this.supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));
        this.supplierRepository.delete(supplier);
    }
}