package com.step.read;

import com.step.person.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.step.App.*;
import static com.step.manager.PersonManagerInFile.personIndex;

public class ReadObjectPersonData {
    public static List<Person> ReadObjectPersonFromFile() {
        List<Person> arrList = new ArrayList<>();
        personIndex = 0;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"));
            try {
                while (true) {

                    Person person = (Person) objectInputStream.readObject();

                    if (person == null) {
                        break;
                    } else {
                        arrList.add(personIndex, person);
//                        per.add(person);
                        personIndex++;
                    }
                }
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Solved EOF");
            }

        } catch (Exception ex) {
            System.out.println("No  person.dat found. Skipping importing the data");

        }
        return arrList;
    }
}
