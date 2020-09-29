package com.step.model.home.door;

import java.util.Scanner;

public class Door {
    double weight;
    double height;
    String color;

    public void close(){
        System.out.println("Door is closed");
    }
    public void open(){
        System.out.println("Opening the door");
    }

    public void doorOptions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the door of your room. \nWould you like to to come in(y or n)?");
        char ch = sc.nextLine().charAt(0);     // char

           if(ch=='y'){
                System.out.println("This is your room");
           }
           else System.out.println("OK. Let's go to take a coffee");
    }

}
