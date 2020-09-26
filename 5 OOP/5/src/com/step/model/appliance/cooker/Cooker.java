package com.step.model.appliance.cooker;

public class Cooker {
    double volume;
    String name;
    byte levels;

    public void cook(long cookTime,int temp){
        double time=cookTime;
        int temparature=temp;
        System.out.println("Setup setting for: Temperature = "+ temparature+ " \"degrees\" and Cooking time is: "+ cookTime+ " ms." );
        System.out.println("Cooking start");
        for (int i=0;i<5;i++){
            System.out.print('.');
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        System.out.println("\nPie is ready after "+cookTime + " ms.");
    }
    public void setup(){
        cook(5000,170);
    }

}
