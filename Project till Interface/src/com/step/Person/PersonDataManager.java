package com.step.person;

import com.step.menu.Menu;

import java.time.LocalDate;

import java.util.*;

public class PersonDataManager {
    public static int personIndex;
    public static boolean searched = false;
    public static List<Person> per = new ArrayList<>();

    private static void add(Person person) {
        per.add(person);
        personIndex++;
    }

    public static void modify(int attrToModify) {
        String newValue;
        listPerson();
        System.out.println("Select ID of the person to modify");
        int personToModify = -1;
//        int option = 0;
        boolean isValid = false;
        do {
            try {
                personToModify = Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);

        switch (attrToModify) {
            case 1:
                newValue = enterText("Enter new value for Description");
                per.get(personToModify).setDescription(newValue);
                break;
            case 2:
                newValue = enterText("Enter new value for Phone");
                per.get(personToModify).setPhone(newValue);
                break;
            case 3:
                newValue = enterText("Enter new value for Mobile");
                per.get(personToModify).setMobile(newValue);
                break;
            case 4:
                newValue = enterText("Enter new value for Email");
                per.get(personToModify).setEmail(newValue);
                break;
        }
    }

    public static void delete() {
        listPerson();
        System.out.println("Select ID of the person to delete");
        int personToDelete = -1;
//        int option = 0;
        boolean isValid = false;
        do {
            try {
                personToDelete = Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);

        per.remove(personToDelete);
        personIndex--;
        //listPerson();
    }

    public static String enterText(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    public static void collectPersonInfo() {
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
            if (checkIDNP(idnp)) {
                exist = true;
                System.out.println("Person with this IDNP already exist!");
            }
        } while (exist);


        LocalDate today = LocalDate.now();
        add(new Person(personName, surname, description, phone, mobile, email, idnp, today));
    }

    public static void listPerson() {
        int i = 0;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%3s %15s %15s %10s %10s %30s %20s %13s", "ID", "NAME ", "SURNAME", "PHONE", "MOBILE", "EMAIL ID", "DESCRIPTION", "IDNP");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Person person : per) {
            System.out.format("%3d %15s %15s %10s %10s %30s %20s %13s",
                    i, person.getName(), person.getSurname(), person.getPhone(), person.getMobile(), person.getEmail(), person.getDescription(), person.getIdnp());
            i++;
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    public static boolean checkIDNP(String idnp) {
        boolean found = false;
        for (int i = 0; i < personIndex; i++) {
            if (per.get(i).getIdnp().equals(idnp)) {
                found = true;
            }
        }
        return found;
    }

    public static void search(int attrToSearch) {
        String valueToSearch;
        switch (attrToSearch) {
            case 1:
                valueToSearch = enterText("Enter new value for IDNP to search");
                searchByIdnp(valueToSearch);
                break;
            case 2:
                valueToSearch = enterText("Enter new value for Surname to search");
                searchBySurname(valueToSearch);
                break;
            case 3:
                valueToSearch = enterText("Enter new value for Phone to search");
                searchByPhone(valueToSearch);
                break;
            case 4:
                valueToSearch = enterText("Enter new value for Mobil to search");
                searchByMobil(valueToSearch);
                break;
        }
        if (searched == false) {
            System.out.println("!!! Searched value was not found");
        } else searched = false;

    }

    public static void searchByIdnp(String idnp) {
        Map<String, List<Person>> personByIdnp = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByIdnp.containsKey(per.get(i).getIdnp())) {
                personByIdnp.put(per.get(i).getIdnp(), new ArrayList<>());
            }
            personByIdnp.get(per.get(i).getIdnp()).add(per.get(i));
        }
        for (Map.Entry<String, List<Person>> infoIdnp : personByIdnp.entrySet()) {
            if (infoIdnp.getKey().matches(".*" + idnp + ".*")) {
                System.out.print("IDNP: " + infoIdnp.getKey());
                System.out.print(" => Value: " + infoIdnp.getValue());
                System.out.println();
                searched = true;
            }
        }
    }

    public static void searchBySurname(String surname) {
        Map<String, List<Person>> personBySurname = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personBySurname.containsKey(per.get(i).getSurname())) {
                personBySurname.put(per.get(i).getSurname(), new ArrayList<>());
            }
            personBySurname.get(per.get(i).getSurname()).add(per.get(i));
        }
        for (Map.Entry<String, List<Person>> infoSurname : personBySurname.entrySet()) {
            if (infoSurname.getKey().matches(".*" + surname + ".*")) {
                System.out.print("Surname: " + infoSurname.getKey());
                System.out.print(" => Value: " + infoSurname.getValue());
                System.out.println();
                searched = true;
            }
        }
    }

    public static void searchByPhone(String phone) {
        Map<String, List<Person>> personByPhone = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByPhone.containsKey(per.get(i).getPhone())) {
                personByPhone.put(per.get(i).getPhone(), new ArrayList<>());
            }
            personByPhone.get(per.get(i).getPhone()).add(per.get(i));
        }
        for (Map.Entry<String, List<Person>> infoPhone : personByPhone.entrySet()) {
            if (infoPhone.getKey().matches(".*" + phone + ".*")) {
                System.out.print("Phone: " + infoPhone.getKey());
                System.out.print(" => Value: " + infoPhone.getValue());
                System.out.println();
                searched = true;
            }
        }
    }

    public static void searchByMobil(String mobil) {
        Map<String, List<Person>> personByMobil = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByMobil.containsKey(per.get(i).getMobile())) {
                personByMobil.put(per.get(i).getMobile(), new ArrayList<>());
            }
            personByMobil.get(per.get(i).getMobile()).add(per.get(i));
        }
        for (Map.Entry<String, List<Person>> infoMobil : personByMobil.entrySet()) {
            if (infoMobil.getKey().matches(".*" + mobil + ".*")) {
                System.out.print("Mobil phone: " + infoMobil.getKey());
                System.out.print(" => Value: " + infoMobil.getValue());
                System.out.println();
                searched = true;
            }
        }
    }
}