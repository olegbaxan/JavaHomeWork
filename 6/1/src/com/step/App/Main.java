package com.step.App;

import com.step.converter.TempConverter;

public class Main {
    public static void main(String[] args){
        TempConverter tempMeasure=new TempConverter();
        tempMeasure.convertToCelsius(100);
        tempMeasure.convertToFahr(100);
    }

}
