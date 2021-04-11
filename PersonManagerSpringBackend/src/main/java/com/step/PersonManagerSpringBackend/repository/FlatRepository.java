package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Integer> {
}
