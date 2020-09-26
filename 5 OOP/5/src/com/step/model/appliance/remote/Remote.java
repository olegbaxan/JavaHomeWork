package com.step.model.appliance.remote;

import com.step.model.appliance.tv.TV;

public class Remote {
    String colour;
    String brand;

    public void show(int channel){
        System.out.print(channel);

        if(channel==7)TV.show();
        else System.out.println("");
    }
    public void press(int channel){
        show(channel);
    }
}
