package com.step.read;

import com.step.person.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import static com.step.person.PersonDataManager.per;

public class ReadObjectPersonData {
    public static void ReadObjectPersonFromFile() {
        try {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"));
        while (true) {

                Object person = objectInputStream.readObject();
                if (person == null) {
                    break;
                }
                per.add((Person)person);
            }
            objectInputStream.close();
        }
        catch (Exception ex) {
                System.out.println("Solved EOF");

        }

    }
}
