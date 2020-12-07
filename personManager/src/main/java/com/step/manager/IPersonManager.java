package com.step.manager;

import com.step.person.Person;

import java.sql.SQLException;
import java.util.List;

public interface IPersonManager {
    int insert(List<Person> person) throws SQLException;
    int update(int num, List<Person> person);
    int search(int num, List<Person> person);
    int delete(List<Person> person);
    List<Person> read(List<Person> person);
    void show(List<Person> person);
    void close(List<Person> person);
}
