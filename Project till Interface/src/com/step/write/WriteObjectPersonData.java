package com.step.write;

import com.step.person.Person;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import static com.step.person.PersonDataManager.per;

public class WriteObjectPersonData {
    public static void WriteObjectPersonDataToFile(){
    try {
        FileOutputStream outputFile = new FileOutputStream("person.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputFile);
        for (Person person : per){
            objectOutputStream.writeObject(person);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}}
