package com.step.model.appliance.phone;

public class Phone {
    String brand;
    int ram;
    double display;

    private void switchOff(){
        System.out.println("Phone was switched off");
    }
    private void present(String _brand, int _ram,double _display){
        String prBrand=_brand;
        int prRam=_ram;
        double prDisplay=_display;

        System.out.println("My new new "+ brand+" has "+ ram+ " GB of RAM and a "+ display+ " inch display");
        switchOff();
    }
    public void switchOn(String _brand, int _ram,double _display){
        brand=_brand;
        ram=_ram;
        display=_display;
        System.out.println("Phone is swithing on");
        present(brand,ram,display);
    }
}
