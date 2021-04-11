package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
}
