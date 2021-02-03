package com.step.write;

//import com.step.person.PersonDataManager;

import com.step.files.FilePaths;
import com.step.person.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritePersonDataToFile {
    private static final String delimiter = ",";
    private static final String newLine = "\n";
    private static final String fileHeader = "id,name,surname,description,phone,mobile,email,register date, idnp,birthday";

    public static void savePersonDataToCSV(List<Person> person){
            try {
                String folderPath = FilePaths.selectDirectory();
//                BufferedWriter savePerson =new BufferedWriter( new FileWriter(System.getProperty("user.dir")+"\\src\\main\\java\\person.csv", false));
                BufferedWriter savePerson =new BufferedWriter( new FileWriter(folderPath+"\\person.csv", false));

                savePerson.append(fileHeader);
                savePerson.append(newLine);
                int i=0;

                //Write Person object list to the CSV file
                for (Person per : person) {

                    //int personid, String name, String surname, String description, String phone, String mobil, String email, LocalDate regdate, String idnp
                    savePerson.append(String.valueOf(per.getPersonId()));
                    savePerson.append(delimiter);
                    savePerson.append(per.getName());
                    savePerson.append(delimiter);
                    savePerson.append(per.getSurname());
                    savePerson.append(delimiter);
                    savePerson.append(per.getDescription());
                    savePerson.append(delimiter);
                    savePerson.append(per.getPhone());
                    savePerson.append(delimiter);
                    savePerson.append(per.getMobile());
                    savePerson.append(delimiter);
                    savePerson.append(per.getEmail());
                    savePerson.append(delimiter);
                    savePerson.append(String.valueOf(per.getRegDate()));
                    savePerson.append(delimiter);
                    savePerson.append(per.getIdnp());
                    savePerson.append(delimiter);
                    savePerson.append(String.valueOf(per.getBirthday()));

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
