package com.step.model.appliance.fridge;

public class Fridge {
    String brand;
    String name;
    double height;

    public void closeDoor(){
        System.out.println("Door closed");
    }
    public void takeFood(){
        System.out.println("Take food");
        closeDoor();
    }
    public void openDoor(){
        System.out.println("Open fridge door");
        takeFood();
    }
}
