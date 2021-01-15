package com.step;

import com.step.person.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List <Person> person = new ArrayList<>();
        person.add(new Person("Sergiu", 10000.0,Gender.M, LocalDate.of(2000,01,01)));
        person.add(new Person("Maria", 8700.0,Gender.F, LocalDate.of(1970,8,10)));
        person.add(new Person("Stela", 12500.0,Gender.F, LocalDate.of(1950,6,25)));
        person.add(new Person("Ioana", 6500.0,Gender.F, LocalDate.of(1995,3,19)));
        person.add(new Person("Inga", 2500.0,Gender.F, LocalDate.of(1993,3,19)));
        person.add(new Person("Uliana", 2500.0,Gender.F, LocalDate.of(1990,3,19)));
        person.add(new Person("Ghenadie", 11000.0,Gender.M, LocalDate.of(2001,2,28)));
        person.add(new Person("Svetlana", 9800.0,Gender.F, LocalDate.of(2000,12,31)));
        person.add(new Person("Gheorghe", 11000.0,Gender.M, LocalDate.of(2002,2,28)));
        person.add(new Person("Marin", 12000.0,Gender.M, LocalDate.of(2003,2,28)));


        biggerSalary(person);
        womenBirthdayAfter1990(person);
        displayMen(person);
        displaySortedSalaries(person);
        onlyDistinctSalaries(person);
    }
    //1.	3 persoane care au salariul cel mai mare salariu din lista
    public static void biggerSalary(List<Person> person){
        System.out.println("1.---------------------------------------");
        person.stream().map(p->p.getSalary())
                .sorted((s1, s2) -> s2.intValue() - s1.intValue())
                .limit(3)
                .forEach(salary-> System.out.println(salary));
        System.out.println("2.---------------------------------------");
    }
    //2.	2 femei care au birthdate după 01.01.1990
    public static void womenBirthdayAfter1990(List<Person> person){
        person.stream()
                .filter(p -> p.getGender() == Gender.F)
                .filter(female -> female.getBirthdate().isAfter(LocalDate.of(1990, Month.JANUARY, 01)))
                .limit(2)
                .forEach(female -> System.out.println(female.getName()));
        System.out.println("3.---------------------------------------");
    }
    //3.	Informatia despre bărbații din listă
    public static void displayMen(List<Person> person){
        person.stream()
                .filter(men->men.getGender()==Gender.M)
                .forEach(men-> System.out.println(men.getName()));
        System.out.println("4.---------------------------------------");
    }
    //4.	Doar salariile tuturor persoanelor ordonate crescător
    public static void displaySortedSalaries(List<Person> person){
        person.stream()
                .map(p->p.getSalary())
                .sorted((s1,s2)->(s2.intValue()-s1.intValue()))
                .forEach(salary-> System.out.println(salary));
        System.out.println("5.---------------------------------------");
    }

    //5.	Doar salariile unice ale persoanelor
    public static void onlyDistinctSalaries(List<Person> person){
        person.stream()
                .map(p->p.getSalary())
                .distinct()
                .sorted((s1,s2)->(s2.intValue()-s1.intValue()))
                .forEach(salary-> System.out.println(salary));
    }

}
