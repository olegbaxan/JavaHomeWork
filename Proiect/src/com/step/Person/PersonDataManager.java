package com.step.Person;
import com.step.Menu.Menu;
import com.step.Person.Person;
import java.time.LocalDate;

import java.util.*;
import java.util.stream.IntStream;

public class PersonDataManager {
    public static int personIndex;
    public static boolean searched=false;
    private static Person [] per = new Person[100];
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
    public static void search(int attrToSearch){
        String valueToSearch;
        switch (attrToSearch){
            case 1: valueToSearch=enterText("Enter new value for IDNP to search"); searchByIdnp(valueToSearch) ;break;
            case 2: valueToSearch=enterText("Enter new value for Surname to search");searchBySurname(valueToSearch);break;
            case 3: valueToSearch=enterText("Enter new value for Phone to search");searchByPhone(valueToSearch);break;
            case 4: valueToSearch=enterText("Enter new value for Mobil to search");searchByMobil(valueToSearch);break;
        }
        if(searched==false){
            System.out.println("!!! Searched value was not found");
        }else searched=false;

    }

    public static void searchByIdnp(String idnp){
        Map<String, List<Person>> personByIdnp= new HashMap<>();
        for(int i=0;i<personIndex;i++){
            if(!personByIdnp.containsKey(per[i].getIdnp())){
                personByIdnp.put(per[i].getIdnp(),new ArrayList<>());
            }
            personByIdnp.get(per[i].getIdnp()).add(per[i]);
        }
        for(Map.Entry<String,List<Person>> infoIdnp:personByIdnp.entrySet()){
            if(infoIdnp.getKey().matches(".*"+idnp+".*")) {
                System.out.print("IDNP: " + infoIdnp.getKey());
                System.out.print(" => Value: " + infoIdnp.getValue());
                System.out.println();
                searched=true;
            }
        }
    }
    public static void searchBySurname(String surname){
        Map<String, List<Person>> personBySurname= new HashMap<>();
        for(int i=0;i<personIndex;i++){
            if(!personBySurname.containsKey(per[i].getSurname())){
                personBySurname.put(per[i].getSurname(),new ArrayList<>());
            }
            personBySurname.get(per[i].getSurname()).add(per[i]);
        }
        for(Map.Entry<String,List<Person>> infoSurname:personBySurname.entrySet()){
            if(infoSurname.getKey().matches(".*"+surname+".*")) {
                System.out.print("Surname: " + infoSurname.getKey());
                System.out.print(" => Value: " + infoSurname.getValue());
                System.out.println();
                searched=true;
            }
        }
    }
    public static void searchByPhone(String phone){
        Map<String, List<Person>> personByPhone= new HashMap<>();
        for(int i=0;i<personIndex;i++){
            if(!personByPhone.containsKey(per[i].getPhone())){
                personByPhone.put(per[i].getPhone(),new ArrayList<>());
            }
            personByPhone.get(per[i].getPhone()).add(per[i]);
        }
        for(Map.Entry<String,List<Person>> infoPhone:personByPhone.entrySet()){
            if(infoPhone.getKey().matches(".*"+phone+".*")) {
                System.out.print("Phone: " + infoPhone.getKey());
                System.out.print(" => Value: " + infoPhone.getValue());
                System.out.println();
                searched=true;
            }
        }
    }
    public static void searchByMobil(String mobil){
        Map<String, List<Person>> personByMobil= new HashMap<>();
        for(int i=0;i<personIndex;i++){
            if(!personByMobil.containsKey(per[i].getMobile())){
                personByMobil.put(per[i].getMobile(),new ArrayList<>());
            }
            personByMobil.get(per[i].getMobile()).add(per[i]);
        }
        for(Map.Entry<String,List<Person>> infoMobil:personByMobil.entrySet()){
            if(infoMobil.getKey().matches(".*"+mobil+".*")) {
                System.out.print("Mobil phone: " + infoMobil.getKey());
                System.out.print(" => Value: " + infoMobil.getValue());
                System.out.println();
                searched=true;
            }
        }
    }
}