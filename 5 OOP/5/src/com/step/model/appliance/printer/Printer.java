package com.step.model.appliance.printer;

public class Printer {
    String brand;
    int hdd;
    String pageFormat;

    public String print(String _text){
        System.out.println(_text);
        return "Page was printed";
    }
}
