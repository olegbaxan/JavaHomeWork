package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
    //List<Meter> findMeterByMeterIdIsIn(List<Integer> id);
    List<Meter> findByMeterIdIsIn(List<Integer> id);
}
