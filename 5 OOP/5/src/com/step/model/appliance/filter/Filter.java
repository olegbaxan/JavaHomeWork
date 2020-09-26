package com.step.model.appliance.filter;

public class Filter {
        String brand;
        String name;
        double volume;

        public void tapOff () {
            System.out.println("\nTake your glass of water");
        }
        public void tapOn () {
            System.out.println("Start filtering water");
            for (int i = 0; i < 5; i++) {
                System.out.print('.');
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            tapOff();

        }
}
