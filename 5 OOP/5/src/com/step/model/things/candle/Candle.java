package com.step.model.things.candle;

public class Candle {
    double price;
    String color;

    public void burn(){
        System.out.println("Candle in the wind");
    }
    public void lighting(){
        System.out.println("Light the candle");
        burn();
    }
}
