package com.step.model;

public class Doctor extends Person{
    private String activityDomain;

    public void intervention(){

    }
    public void prescription(String reteta){
        buy(reteta);
    }
}
