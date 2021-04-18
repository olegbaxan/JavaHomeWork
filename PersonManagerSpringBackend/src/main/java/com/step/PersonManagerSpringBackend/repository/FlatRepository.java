package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Flat;
import com.step.PersonManagerSpringBackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Integer> {

     List<Flat> findFlatsByFlatidIsIn(List<Integer> id);

     List<Flat> findFlatByPersons (Person person);
}
