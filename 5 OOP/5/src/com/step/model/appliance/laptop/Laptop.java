package com.step.model.appliance.laptop;

public class Laptop {
    String brand;
    int ram;
    double screen;

    public void shutdown(){
        System.out.println("Shutdown");
    }
        public void process(int first, int second){
            int a=first;
            int b=second;
            System.out.println("Rezult a+b is "+ a+b);
            shutdown();
        }
        public void start(){
            System.out.println("Starting Windows...");
            process(5,8);
        }
    }

