package com.step.PersonManagerSpringBackend.service;

import com.step.PersonManagerSpringBackend.model.Address;
import com.step.PersonManagerSpringBackend.model.dto.AddressDTO;
import com.step.PersonManagerSpringBackend.repository.AddressRepository;
import com.step.PersonManagerSpringBackend.service.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public AddressDTO save(AddressDTO addressDTO) throws AddressNotFoundException {
        final Address newAddress = new Address();
        newAddress.setCity(addressDTO.getCity());
        newAddress.setRaion(addressDTO.getRaion());
        newAddress.setStreet(addressDTO.getStreet());
        newAddress.setHouseNumber(addressDTO.getHouseNumber());

        final Address addAddress = addressRepository.save(newAddress);
        return AddressDTO.from(newAddress);
    }

    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(addresses -> AddressDTO.from(addresses)).collect(Collectors.toList());

    }

    public AddressDTO findById(Integer id) throws AddressNotFoundException {
        final Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        return AddressDTO.from(address);
    }

    public Object update(AddressDTO addressToUpdate) throws AddressNotFoundException {

        final Address address = this.addressRepository.findById(addressToUpdate.getAddressid()).orElseThrow(() -> new AddressNotFoundException(addressToUpdate.getAddressid()));
        address.setCity(addressToUpdate.getCity());
        address.setRaion(addressToUpdate.getRaion());
        address.setStreet(addressToUpdate.getStreet());
        address.setHouseNumber(addressToUpdate.getHouseNumber());
        final Address savedAddress = this.addressRepository.save(address);
        return AddressDTO.from(savedAddress);
    }

    public void delete(Integer id) throws AddressNotFoundException {
        final Address address = this.addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        this.addressRepository.delete(address);
    }
}
