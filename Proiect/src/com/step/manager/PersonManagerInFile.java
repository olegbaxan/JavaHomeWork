package com.step.manager;

import com.step.menu.Menu;
import com.step.person.Person;
import com.step.write.WriteObjectPersonData;

import java.time.LocalDate;
import java.util.*;

public class PersonManagerInFile implements IPersonManager {
    public static int personIndex;
    public static boolean searched = false;

    @Override
    public int add(List<Person> person) {
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


        personIndex++;
        return 0;
    }
    @Override
    public int  modify(int attrToModify, List<Person> person) {
        String newValue;
        listPerson(person);
        System.out.println("Select ID of the person to modify");
        int personToModify = -1;
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
                person.get(personToModify).setDescription(newValue);
                break;
            case 2:
                newValue = enterText("Enter new value for Phone");
                person.get(personToModify).setPhone(newValue);
                break;
            case 3:
                newValue = enterText("Enter new value for Mobile");
                person.get(personToModify).setMobile(newValue);
                break;
            case 4:
                newValue = enterText("Enter new value for Email");
                person.get(personToModify).setEmail(newValue);
                break;
        }
        return 0;
    }
    @Override
    public int delete(List<Person> person) {
        listPerson(person);
        System.out.println("Select ID of the person to delete");
        int personToDelete = -1;
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

        person.remove(personToDelete);
        personIndex--;
        return 0;
    }

    @Override
    public void close(List<Person> person) {
        WriteObjectPersonData.WriteObjectPersonDataToFile(person);
    }

    public static String enterText(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

@Override
    public int listPerson(List<Person> person) {
        int i = 0;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%3s %15s %15s %10s %10s %30s %20s %13s", "ID", "NAME ", "SURNAME", "PHONE", "MOBILE", "EMAIL ID", "DESCRIPTION", "IDNP");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (Person pers : person) {
            System.out.format("%3d %15s %15s %10s %10s %30s %20s %13s",
                    i, pers.getName(), pers.getSurname(), pers.getPhone(), pers.getMobile(), pers.getEmail(), pers.getDescription(), pers.getIdnp());
            i++;
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        return 0;
    }

    public static boolean checkIDNP(String idnp, List<Person> person) {
        boolean found = false;
        for (int i = 0; i < personIndex; i++) {
            if (person.get(i).getIdnp().equals(idnp)) {
                found = true;
                break;
            }
        }
        return found;
    }
    @Override
    public int search(int attrToSearch, List<Person> person) {
        String valueToSearch;
        switch (attrToSearch) {
            case 1:
                valueToSearch = enterText("Enter new value for IDNP to search");
                searchByIdnp(valueToSearch,person);
                break;
            case 2:
                valueToSearch = enterText("Enter new value for Surname to search");
                searchBySurname(valueToSearch,person);
                break;
            case 3:
                valueToSearch = enterText("Enter new value for Phone to search");
                searchByPhone(valueToSearch,person);
                break;
            case 4:
                valueToSearch = enterText("Enter new value for Mobil to search");
                searchByMobil(valueToSearch,person);
                break;
        }
        if (!searched) {
            System.out.println("!!! Searched value was not found");
        } else searched = false;
        return 0;
    }

    public static void searchByIdnp(String idnp, List<Person> person) {
        Map<String, List<Person>> personByIdnp = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByIdnp.containsKey(person.get(i).getIdnp())) {
                personByIdnp.put(person.get(i).getIdnp(), new ArrayList<>());
            }
            personByIdnp.get(person.get(i).getIdnp()).add(person.get(i));
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

    public static void searchBySurname(String surname, List<Person> person) {
        Map<String, List<Person>> personBySurname = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personBySurname.containsKey(person.get(i).getSurname())) {
                personBySurname.put(person.get(i).getSurname(), new ArrayList<>());
            }
            personBySurname.get(person.get(i).getSurname()).add(person.get(i));
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

    public static void searchByPhone(String phone, List<Person> person) {
        Map<String, List<Person>> personByPhone = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByPhone.containsKey(person.get(i).getPhone())) {
                personByPhone.put(person.get(i).getPhone(), new ArrayList<>());
            }
            personByPhone.get(person.get(i).getPhone()).add(person.get(i));
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

    public static void searchByMobil(String mobil, List<Person> person) {
        Map<String, List<Person>> personByMobil = new HashMap<>();
        for (int i = 0; i < personIndex; i++) {
            if (!personByMobil.containsKey(person.get(i).getMobile())) {
                personByMobil.put(person.get(i).getMobile(), new ArrayList<>());
            }
            personByMobil.get(person.get(i).getMobile()).add(person.get(i));
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
