package com.step.read;

import com.step.person.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import static com.step.person.PersonDataManager.per;
import static com.step.person.PersonDataManager.personIndex;

public class ReadFromFile {
    //Delimiter used in CSV file
    private static final String delimiter = ",";

    public static void readPersonFromFile() {
        try {
            String line = "";

            BufferedReader readPerson = new BufferedReader(new FileReader("E:\\Dropbox\\STEP_IT\\HomeWork\\Java\\Proiect\\person.csv"));

            //Read the CSV file header
            readPerson.readLine();

            //Read the file line by line starting from the second line
            while ((line = readPerson.readLine()) != null) {
                String[] attributes = line.split(delimiter);
                if (attributes.length > 0) {
                    //Create a new Person object and fill in data
                    //String name, String surname, String description, String phone, String mobile, String email, String idnp, LocalDate today
                    Person person = new Person(attributes[1], attributes[2], attributes[3], attributes[4], attributes[5],attributes[6],attributes[7],LocalDate.parse(attributes[8]));
                    personIndex = Integer.parseInt(attributes[0]);
                    per.add(person);
                }
            }
            readPerson.close();
        }
        catch (IOException e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        }
    }
}
