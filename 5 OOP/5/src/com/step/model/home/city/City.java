package com.step.model.home.city;

public class City {
    String name;
    String country;
    double population;

    public void presentation(String _name, String _country, double _population){
        name=_name;
        country=_country;
        population=_population;

        System.out.println("This is "+ name+ " a city from "+ country+", with "+population+" mln people");
    }
}
