package com.step.Person;
import com.step.Person.Person;

import java.util.Scanner;

public class PersonDataManager {
    static int i=0;
    public static void add(){
        Person []per = new Person[100];

        per[i]=new Person();
        String personName=enterText("Enter name of the Person");
        per[i].setName(personName);
        String surname=enterText("Enter surname of the Person");
        per[i].setSurname(surname);
        String description=enterText("Enter description of the Person");
        per[i].setDescription(description);
        String phone=enterText("Enter phone of the Person");
        per[i].setPhone(phone);
        String mobile=enterText("Enter mobile of the Person");
        per[i].setMobile(mobile);
        String email=enterText("Enter email of the Person");
        per[i].setEmail(email);
        i++;
    }
    public void modify(){}
    public void delete(){}
    public void view(){}
    public void search(){}



    public static String enterText(String message) {
        Scanner sc=new Scanner(System.in);
        System.out.println(message);
        String text=sc.nextLine();
        return text;
    }
}
