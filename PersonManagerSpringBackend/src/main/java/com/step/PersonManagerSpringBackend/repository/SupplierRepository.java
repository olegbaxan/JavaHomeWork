package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
