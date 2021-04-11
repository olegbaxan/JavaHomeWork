package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Address;
import com.step.PersonManagerSpringBackend.model.dto.AddressDTO;
import com.step.PersonManagerSpringBackend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressDTOService {
    @Autowired
    private AddressRepository addressRepository;


    public void create(AddressDTO dto) throws Exception {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setRaion(dto.getRaion());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());

        Address savedAddress=this.addressRepository.save(address);

    }
    public List<AddressDTO> getAll() {
        // get all addresses
        final List<Address> all = this.addressRepository.findAll(Sort.by(Sort.Direction.ASC, "addressid"));
        // convert to DTO
        List<AddressDTO> dtos = all.stream().map(address -> AddressDTO.from(address)
        ).collect(Collectors.toList());
        return dtos;
    }
    public AddressDTO getById(Integer id) throws Exception {
        final Optional<Address> optionalAddress = this.addressRepository.findById(id);
        if(!optionalAddress.isPresent()){
            throw new Exception("Address with id=" + id +" does not exist.");
        }
        final Address address = optionalAddress.get();
        return AddressDTO.from(address);
    }
    public void update(AddressDTO addressToUpdate) throws Exception{
        final Integer addressId = addressToUpdate.getAddressid();
        Optional<Address> optionalAddress =  this.addressRepository.findById(addressId);
        if(!optionalAddress.isPresent()){
            throw new Exception("Address with id=" + addressId +" does not exist.");
        }
        final Address address = optionalAddress.get();
        address.setCity(addressToUpdate.getCity());
        address.setRaion(addressToUpdate.getRaion());
        address.setStreet(addressToUpdate.getStreet());
        address.setHouseNumber(addressToUpdate.getHouseNumber());
        this.addressRepository.save(address);
    }

    public void delete(Integer id) throws Exception {
        Address address = this.addressRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Address does not exist"));
        this.addressRepository.delete(address);
    }


}
