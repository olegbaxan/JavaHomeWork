package com.step.manager;

import com.step.person.Person;

import java.util.List;

public class PersonManagerDB implements IPersonManager {
    public int add(Person person) {
        return 0;
    }

    @Override
    public int add(List<Person> person) {
        return 0;
    }

    @Override
    public int modify(int num, List<Person> person) {
        return 0;
    }

    @Override
    public int search(int num, List<Person> person) {
        return 0;
    }

    public int modify(Person person) {
        return 0;
    }

    public List<Person> search() {
        return null;
    }

    public int delete(List<Person> person) {
        return 0;
    }

    @Override
    public int listPerson(List<Person> person) {
        return 0;
    }

    public void close(List<Person> person) {

    }
}