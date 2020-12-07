package com.step.write;

import com.step.person.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteObjectPersonData {
    public static void WriteObjectPersonDataToFile(List<Person> person){
    try {
        FileOutputStream outputFile = new FileOutputStream("E:\\Dropbox\\STEP_IT\\HomeWork\\Java\\personManager\\src\\main\\java\\person.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputFile);
        for (Person pers : person){
            objectOutputStream.writeObject(pers);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}}
