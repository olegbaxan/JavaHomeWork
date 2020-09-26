package com.step.model.things.bicycle;

public class Bicycle {
    String brand;
    int wheels;


    public void ridding(){
        System.out.println("Ridding the bike");
    }
    public void start(){
        System.out.println("Starting Tour de France");
        ridding();
    }
    
}
