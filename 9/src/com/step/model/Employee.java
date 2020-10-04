package com.step.model;

import com.step.App;

import java.util.Scanner;

public class Employee {
    private String text;
    private String name;

    Scanner sc=new Scanner(System.in);

    public Employee() {

    }
    public Employee(String n){
        this.name=n;
    }

    public static int order(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        return num;
    }

//    Exercițiu practic #3

public void listEmployee(){
    System.out.println("Name of Employee is: " + name);
}




/*Exercițiu practic #2*/
    public void enterText(){
        System.out.println("Enter a text phrase: ");
        text=sc.nextLine();
        listLetter();
    }
    public void listLetter(){
        int num= order();
        String st = text.replaceAll("\\s+","");

        try {
            System.out.println("Character is: "+num+" - "+st.charAt(num-1));
        }catch (StringIndexOutOfBoundsException ex){
            System.out.println("Out of bounds");
        }
    }


}
