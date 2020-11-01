package com.step.Person;
import com.step.Menu.Menu;
import com.step.Person.Person;
import java.time.LocalDate;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PersonDataManager {
    public static int personIndex;
    private static Person []per = new Person[100];
    private static void add(Person person){
        per[personIndex]=person;
        personIndex++;
    }
    public static void modify(int attrToModify){
        String newValue;
        listPerson();
        System.out.println("Select ID of the person to modify");
        int personToModify=-1;
        int option=0;
        boolean isValid = false;
        do {
            try{
                personToModify= Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while(!isValid);

        switch (attrToModify){
            case 1: newValue=enterText("Enter new value for Description"); per[personToModify].setDescription(newValue);break;
            case 2: newValue=enterText("Enter new value for Phone");per[personToModify].setPhone(newValue);break;
            case 3: newValue=enterText("Enter new value for Mobile");per[personToModify].setMobile(newValue);break;
            case 4: newValue=enterText("Enter new value for Email");per[personToModify].setEmail(newValue);break;
        }
    }

    public static void delete(){
        listPerson();
        System.out.println("Select ID of the person to delete");
        int personToDelete=-1;
        int option=0;
        boolean isValid = false;
        do {
            try{
                personToDelete= Menu.getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while(!isValid);

        for (int i = personToDelete; i < per.length - 1; i++) {
            per[i] = per[i + 1];
        }
        personIndex--;
        //listPerson();
    }

    public static String enterText(String message) {
        Scanner sc=new Scanner(System.in);
        System.out.println(message);
        String text=sc.nextLine();
        return text;
    }
    public static void collectPersonInfo(){
        String personName=enterText("Enter name of the Person");
        String surname=enterText("Enter surname of the Person");
        String description=enterText("Enter description of the Person");
        String phone=enterText("Enter phone of the Person");
        String mobile=enterText("Enter mobile of the Person");
        String email=enterText("Enter email of the Person");
        String idnp;
        boolean exist;
        do {
            exist=false;
            idnp=enterText("Enter IDNP of the Person");
            if(checkIDNP(idnp)==true){
                exist=true;
                System.out.println("Person with this IDNP already exist!");
            }
        }while(exist);


        LocalDate today=LocalDate.now();
        add(new Person(personName,surname,description,phone,mobile,email,idnp,today));
    }

    public static void listPerson(){
    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    System.out.printf ("%3s %15s %15s %10s %10s %30s %20s %13s", "ID","NAME ","SURNAME", "PHONE", "MOBILE", "EMAIL ID", "DESCRIPTION","IDNP");
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    for(int i=0;i<personIndex;i++){
        System.out.format("%3d %15s %15s %10s %10s %30s %20s %13s",
               i,per[i].getName(), per[i].getSurname(), per[i].getPhone(), per[i].getMobile(), per[i].getEmail(),per[i].getDescription(),per[i].getIdnp());
    System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }
    public static boolean checkIDNP(String idnp){
        boolean found=false;
        for(int i=0;i<personIndex;i++){
            if(per[i].getIdnp().equals(idnp)){
                found=true;
            }
        }
        return found;
    }
}