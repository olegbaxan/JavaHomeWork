package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
