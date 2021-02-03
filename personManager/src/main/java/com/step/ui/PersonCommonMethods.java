package com.step.ui;

import com.step.exception.NumberNotValidException;
import com.step.person.Person;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class personInsertData {
    public static List<Person> insertData(List<Person> person){
        String personName = enterText("Enter name of the Person");
        String surname = enterText("Enter surname of the Person");
        String description = enterText("Enter description of the Person");
        String phone = enterText("Enter phone of the Person");
        String mobile = enterText("Enter mobile of the Person");
        String email = enterText("Enter email of the Person");
        String idnp;
        boolean exist;
        do {
            exist = false;
            idnp = enterText("Enter IDNP of the Person");
            if (checkIDNP(idnp,person)) {
                exist = true;
                System.out.println("Person with this IDNP already exist!");
            }
        } while (exist);


        LocalDate today = LocalDate.now();
        person.add(new Person(personName, surname, description, phone, mobile, email, idnp, today));

        return person;
    }

    public void showPerson(List<Person> person){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%3s %15s %15s %10s %10s %30s %20s %13s", "ID", "NAME ", "SURNAME", "PHONE", "MOBILE", "EMAIL ID", "DESCRIPTION", "IDNP");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Person pers : person) {
            System.out.format("%3d %15s %15s %10s %10s %30s %20s %13s",
                    pers.getPersonId(), pers.getName(), pers.getSurname(), pers.getPhone(), pers.getMobile(), pers.getEmail(), pers.getDescription(), pers.getIdnp());
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    public static boolean checkIDNP(String idnp, List<Person> person) {
        boolean found = false;
        System.out.println("person.size()=" +person.size());
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).getIdnp().equals(idnp)) {
                System.out.println("idnp="+idnp);
                System.out.println("idnpCheck = "+ person.get(i).getIdnp());
                found = true;
                break;
            }
        }
        return found;
    }

    public static int getOption() throws NumberNotValidException {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Data is not a number");
            throw new NumberNotValidException();
        }
    }

    public static String enterText(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

}
