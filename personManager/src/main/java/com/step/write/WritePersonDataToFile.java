package com.step.write;

//import com.step.person.PersonDataManager;

import com.step.person.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.step.person.PersonDataManager.per;

public class WritePersonDataToFile {
    private static final String delimiter = ",";
    private static final String newLine = "\n";
    private static final String fileHeader = "id,name,surname,description,email,idnp,mobile,phone,register date";

    public static void savePersonDataToFile(){
            try {
                //BufferedWriter savePerson =new BufferedWriter( new FileWriter("E:\\Dropbox\\STEP_IT\\HomeWork\\Java\\Proiect\\person.csv", false));
                BufferedWriter savePerson =new BufferedWriter( new FileWriter("person.csv", false));
                savePerson.append(fileHeader);
                savePerson.append(newLine);
                int i=0;

                //Write Person object list to the CSV file
                for (Person person : per) {
                    //String name, String surname, String description, String phone, String mobile, String email, String idnp, LocalDate today
                    savePerson.append(String.valueOf(i));
                    savePerson.append(delimiter);
                    savePerson.append(person.getName());
                    savePerson.append(delimiter);
                    savePerson.append(person.getSurname());
                    savePerson.append(delimiter);
                    savePerson.append(person.getDescription());
                    savePerson.append(delimiter);
                    savePerson.append(person.getPhone());
                    savePerson.append(delimiter);
                    savePerson.append(person.getMobile());
                    savePerson.append(delimiter);
                    savePerson.append(person.getEmail());
                    savePerson.append(delimiter);
                    savePerson.append(person.getIdnp());
                    savePerson.append(delimiter);
                    savePerson.append(String.valueOf(person.getRegDate()));

                    savePerson.append(newLine);
                    i++;
                }
                System.out.println("Person Data copied to CSV file.");
                savePerson.flush();
                savePerson.close();
                System.out.println("CSV file was closed successfully !!!");

            } catch (IOException ex) {
                System.out.println("Error in CsvFileWriter !!!");
                ex.printStackTrace();
            }
    }
}
