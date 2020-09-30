package com.step.model;

public class Policeman extends Person {
    private String Weapon;

    public void trafficControl(){
        System.out.println("Go to left");
    }
    public void fine(String protocol){
        double fine = 1500;
        pay(fine);
    }
}
