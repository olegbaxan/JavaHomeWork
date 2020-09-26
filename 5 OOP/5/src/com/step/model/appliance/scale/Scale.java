package com.step.model.appliance.scale;

public class Scale {
    int maxWeight;
    String type;
    double Weight;

    public void switchOff(){
        System.out.println("Scale is switching off");
    }
    public void show(double _weight){
        this.Weight=_weight;
        System.out.println("\nWeight is "+this.Weight+" kg.");
        switchOff();
    }
    public void measure(){
        System.out.println("Measuring your weight");
        for (int i=0;i<5;i++){
            System.out.print('.');
            try{
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        show(87.5);
    }
    public void switchOn(){
        System.out.println("0.0");
        measure();
    }

}
