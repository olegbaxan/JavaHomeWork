package com.step.model.home.bell;

public class Bell {
    String powerMode;
    String manufacture;

    public void ring(){
        System.out.println("Somebody is coming");
    }
    public void start(){
        System.out.println("I bought a new ring bell");
        System.out.println("Ring-Ring");
        System.out.println("Sorry");
        ring();
    }
}
