package com.step.manager;

import com.step.person.Person;

import java.util.List;

public interface IPersonManager {
    int add(List<Person> person);
    int modify(int num, List<Person> person);
    int search(int num, List<Person> person);
    int delete(List<Person> person);
    int listPerson(List<Person> person);
    void close(List<Person> person);
}
