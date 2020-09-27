package com.step.converter;

public class TempConverter {
    public void convertToFahr(double celsius){
        System.out.println(celsius + "C -> "+ celsius*2.5+ " F");
    }

    public void convertToCelsius(double fahr){
        System.out.println(fahr + "F -> "+ fahr/2.5+ " C");
    }

}
