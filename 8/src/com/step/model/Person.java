package com.step.model;

public class Person {
    protected String name;
    protected String surname;
    protected String birthday;
    protected String educationLevel;
    protected boolean maritalStatus;
    protected String workplace;

    public void buy(String reteta){
        System.out.println("I would like to buy "+ reteta);
        pay(300);
    }
    public void pay(double suma ){
        System.out.println("These are "+ suma + " lei.");
    }
}
