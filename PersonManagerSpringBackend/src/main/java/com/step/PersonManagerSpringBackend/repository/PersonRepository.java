package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
