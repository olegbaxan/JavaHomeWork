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
        List <Double> salary = new ArrayList<>();
        for (Person p:person) {
            salary.add(new Double(p.getSalary()));
            Collections.sort(salary);
        }
        System.out.println("Biggest salaries:");
        for (int i = (salary.size()-1); i > (salary.size() - 4); i--){
            System.out.println(salary.get(i));
        }
        System.out.println("2.---------------------------------------");
    }
    //2.	2 femei care au birthdate după 01.01.1990
    public static void womenBirthdayAfter1990(List<Person> person){
        int count=0;
        for (Person p:person) {
            if(p.getBirthdate().isAfter(LocalDate.of(1990, Month.JANUARY,01))&& p.getGender().equals(Gender.F)){
                count++;
                System.out.println("Women after 1990: "+p.getName());
                if (count==2){
                    break;
                }
            }
        }
        System.out.println("3.---------------------------------------");
    }
    //3.	Informatia despre bărbații din listă
    public static void displayMen(List<Person> person){
        for (int i=0;i<person.size();i++){
            if(person.get(i).getGender().equals(Gender.M)){
                System.out.println("Name ="+person.get(i).getName());
            }

        }
        System.out.println("4.---------------------------------------");
    }
    //4.	Doar salariile tuturor persoanelor ordonate crescător
    public static void displaySortedSalaries(List<Person> person){
        List <Double> salary = new ArrayList<>();
        for (Person p:person) {
            salary.add(new Double(p.getSalary()));
            Collections.sort(salary);
        }
        System.out.println("Salaries:");
        for (int i = 0; i < salary.size(); i++){
            System.out.println(salary.get(i));
        }
        System.out.println("5.---------------------------------------");
    }

    //5.	Doar salariile unice ale persoanelor
    public static void onlyDistinctSalaries(List<Person> person){
        List <Double> salary = new ArrayList<>();
        boolean exist=false;
        for (int i=0;i<person.size();i++) {
            for (int j=0;j<salary.size();j++) {
                if (person.get(i).getSalary().doubleValue() == salary.get(j).doubleValue()) {
                    exist=true;
                }
            }
            if (!exist){
                salary.add(new Double(person.get(i).getSalary()));
            }else {
                exist=false;
            }
        }
        System.out.println("Distinct salaries:");
        for (Double salar:salary ) {
            System.out.println(salar);
        }
    }

}
