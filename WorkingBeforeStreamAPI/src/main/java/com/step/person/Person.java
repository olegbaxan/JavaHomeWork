package com.step.person;

import java.time.LocalDate;

public class Person {
    private String name;
    private Double salary;
    private Enum gender;
    private LocalDate birthdate;

    public Person(String name, Double salary, Enum gender, LocalDate birthdate) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Enum getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public String toString() {
        return String.format("Person (name=%s, salary=%d, gender=%s, birthdt=%s,)", name, salary, gender, birthdate);
//        return String.format("%s,%d,%s,%s", name, salary, gender,birthday);
    }
}
