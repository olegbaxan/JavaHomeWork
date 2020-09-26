package com.step.model.appliance.meter;

public class Meter {
    String type;
    String version;
    int year;

    public void counter(String _type,String _version,int _year){
        type=_type;
        version=_version;
        year=_year;
         System.out.println("Meter count "+ type + " volum and was installed in "+year+ ", this is "+ version + " version");
    }
}
