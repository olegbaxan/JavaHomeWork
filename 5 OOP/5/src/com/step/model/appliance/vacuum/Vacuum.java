package com.step.model.appliance.vacuum;

public class Vacuum {
    String brand;
    String colour;
    String cleanType;

    public void switchOff(){
        System.out.println("\nSwitching Off the vacuum");
    }
    public void clean(){
        System.out.print("Cleaning ");
        for (int i=0;i<5;i++){
            System.out.print('.');
            try{
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        switchOff();
    }
    public void switchOn(){
        System.out.println("Switching On vacuum");
        clean();
    }

}
