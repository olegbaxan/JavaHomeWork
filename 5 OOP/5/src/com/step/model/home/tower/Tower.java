package com.step.model.home.tower;

public class Tower {
    double height=123.4;
    String destination="tourism";
    String name="Tour Eiffel";

    public void presentation(){
        System.out.println(name+ " is the main "+destination+" attraction in Paris. It has "+ height+" meters.");
    }
}
