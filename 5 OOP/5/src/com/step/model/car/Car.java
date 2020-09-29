package com.step.model.car;

public class Car {
    String brand;
    byte doors;
    String color;

    public void breaks(){
        System.out.println("Traffic Light. Breeeeaaaaaaak");
    }
    public void gear(double _speed){
        if(_speed>0&_speed<=10){
            System.out.println("Gear 1");
        }
        else if(_speed>10&_speed<=20){
            System.out.println("Gear 2");
        }
        else if(_speed>20&_speed<=40){
            System.out.println("Gear 3");
        }
        else if(_speed>40&_speed<=60){
            System.out.println("Gear 4");
        }
        else{
            System.out.println("Gear 5");
        }
    }
    public void start(double _speed){
        gear(_speed);
    }
}
