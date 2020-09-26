package com.step.model.home.house;

public class House {
    double surface;
    String owner;
    byte floors;

    public void presentation(double _surface, String _owner, byte _floors){
        this.surface=_surface;
        this.owner=_owner;
        this.floors=_floors;

        System.out.println("This is the house of "+ owner+". It has "+ surface+ " square metters, on "+ floors+ " floor(s)");
    }
}
