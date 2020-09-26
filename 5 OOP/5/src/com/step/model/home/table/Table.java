package com.step.model.home.table;

public class Table {
    byte feet;
    String colour;
    double lengthShort;
    double lengthLong;
    String type;

    public void extend(){
        System.out.println("Table extended");
    }
    public void presentation(String _type,double llong, double lshort){
        lengthLong = llong;
        lengthShort=lshort;
        type=_type;
        System.out.println("This is "+ type+ " table. Normal length is "+ lengthShort+ " but can be extendable till "+ lengthLong);
        extend();
    }
}
