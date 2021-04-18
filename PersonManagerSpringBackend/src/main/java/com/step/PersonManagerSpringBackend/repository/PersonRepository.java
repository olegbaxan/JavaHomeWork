package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findPersonByPersonIdIsIn(List<Integer> id);
    List<Person> findByPersonIdIsIn(List<Integer> id);
    List<Person> findPersonByFlat (Flat flat);

    void deleteByFlatEquals(Flat flat);
}
