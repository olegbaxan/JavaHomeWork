package com.step.model.home.street;

public class Street {
    String name;
    double length;
    double weight;
    String city;

    public void presentation(String _name,double _length, double _weight,String _city){
        name=_name;
        length=_length;
        weight=_weight;
        city=_city;
        System.out.println("This is the newest street in " + city+". The name of the street is "+ name+ ". It has "+ length+" km length and around "+ weight + " metters weight");
    }
}
