package com.step.person;

import com.step.person.PersonDataManager;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import com.step.person.Person;
import static com.step.person.PersonDataManager.*;

public class PersonDataManagerTest extends TestCase {
//    Person p = this.askUser();

    @Test
    public static void testInsert(){
    PersonDataManager pdm=new PersonDataManager();



    Person person1 = new com.step.person.Person("Ion","Ion","descriere1","123","1236","1@md","1234", LocalDate.now());
    Person person2 = new com.step.person.Person("Ion","Ion","descriere1","123","1236","1@md","1234", LocalDate.now());

//        pdm.add(person1);
        add(person1);
        add(person2);

        assertEquals("I added 2 persons",2,per.size());
        assertEquals("Check Person Name","Ion",per.get(0).getName());
        assertEquals("Check Person Surname","Ion",per.get(0).getSurname());
        assertEquals("Check Person Description","descriere1",per.get(0).getDescription());
        assertEquals("Check Person Phone","123",per.get(0).getPhone());
        assertEquals("Check Person Mobile","1236",per.get(0).getMobile());
        assertEquals("Check Person Email","1@md",per.get(0).getEmail());
        assertEquals("Check Person IDNP","1234",per.get(0).getIdnp());
        assertEquals("Check Person Date",LocalDate.now(),per.get(0).getRegDate());
//    per.clear();

    }
    @Test
    public static void testIDNP(){
        Person person1 = new com.step.person.Person("Ion","Ion","descriere1","123","1236","1@md","1234", LocalDate.now());

        add(person1);


        boolean found = checkIDNP("1234");
        assertEquals("Method should return true ",true,found);
        per.clear();
    }
//    public void addTest(){
//
//        Person p = this.askUser(); // <-- aici se fac operatiile cu Scanner, nu trebuie testat
//        PersonDataManager.add(p); // aici se insereaza datele
//
//        assertEquals("Method should return true ","Ion",per.get(1).getName());
//    }
//    public static Person askUser(){
//        Person person;
//
//        String personName = enterText("Enter name of the Person");
//        String surname = enterText("Enter surname of the Person");
//        String description = enterText("Enter description of the Person");
//        String phone = enterText("Enter phone of the Person");
//        String mobile = enterText("Enter mobile of the Person");
//        String email = enterText("Enter email of the Person");
//        String idnp;
//        boolean exist;
//        do {
//            exist = false;
//            idnp = enterText("Enter IDNP of the Person");
//            if (checkIDNP(idnp)) {
//                exist = true;
//                System.out.println("Person with this IDNP already exist!");
//            }
//        } while (exist);
//
//
//        LocalDate today = LocalDate.now();
//        person = new Person(personName, surname, description, phone, mobile, email, idnp, today);
//
//    return person;
//    }


}
