package com.step.model.application;

import com.step.model.animal.cat.Cat;
import com.step.model.animal.dog.Dog;
import com.step.model.appliance.braker.Braker;
import com.step.model.appliance.cooker.Cooker;
import com.step.model.appliance.filter.Filter;
import com.step.model.appliance.fridge.Fridge;
import com.step.model.appliance.laptop.Laptop;
import com.step.model.appliance.meter.Meter;
import com.step.model.appliance.phone.Phone;
import com.step.model.appliance.printer.Printer;
import com.step.model.appliance.remote.Remote;
import com.step.model.appliance.scale.Scale;
import com.step.model.appliance.tv.TV;
import com.step.model.appliance.vacuum.Vacuum;
import com.step.model.car.Car;
import com.step.model.clothes.Clothes;
import com.step.model.home.bell.Bell;
import com.step.model.home.city.City;
import com.step.model.home.door.Door;
import com.step.model.home.house.House;
import com.step.model.home.street.Street;
import com.step.model.home.table.Table;
import com.step.model.home.tower.Tower;
import com.step.model.person.Person;
import com.step.model.things.book.Book;
import com.step.model.things.bicycle.Bicycle;
import com.step.model.things.candle.Candle;
import com.step.model.things.flower.Flowers;
import com.step.model.things.pen.Pen;
import com.step.model.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree copac1=new Tree();
        copac1.initial();
        copac1.tree("cires","fructifer");

        Tree copac2=new Tree();
        copac2.tree("pin", "conifer");

        Pen stilou=new Pen();
        stilou.write();
        stilou.draw();

        Flowers rose=new Flowers();
        rose.flower();

        Candle whiteCandle=new Candle();
        whiteCandle.lighting();

        Bicycle mtb= new Bicycle();
        mtb.start();

        Person ion=new Person();
        ion.day();

        Tower tourEiffel=new Tower();
        tourEiffel.presentation();

        Table kTable=new Table();
        kTable.presentation("extandable",2.5,1.5);

        Street stefanCelMare= new Street();
        stefanCelMare.presentation("Stefan cel Mare si Sfant",4,24,"Chisinau");

        House whiteHouse= new House();
        whiteHouse.presentation(1000, "Donald Trump", (byte) 3);

        Door room =new Door();
        room.doorOptions();

        City Chisinau=new City();
        Chisinau.presentation("Chisinau", "Moldova", 1.1);
        Bell newBell=new Bell();
        newBell.start();

        Clothes pants = new Clothes();
        pants.measure();
        pants.buy();


        Car dacia=new Car();
        for (int i=1;i<100;i++){
            System.out.print('.');
            try{
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i>70){
                dacia.breaks();break;
            }else if (i%10==0)
            dacia.start(i);
            else continue;

        }
        System.out.println("");
        Vacuum philips = new Vacuum();
        philips.switchOn();

        TV lge = new TV();
        Remote lg = new Remote();
        lg.press(5);
        lg.press(7);

        Scale caso = new Scale();
        caso.switchOn();

        Braker kitchen = new Braker();
        kitchen.switchOn();
        kitchen.switchOff();

        Printer canon=new Printer();
        System.out.println(canon.print("This text is a simple verification of the Print class"));

        Phone samsung=new Phone();
        samsung.switchOn("Samsung", 4, 6.25);

        Meter water = new Meter();
        water.counter("water", "Analog", 2017);

        Laptop firstLaptop=new Laptop();
        firstLaptop.start();

        Cat meunica = new Cat();
        meunica.meows();
        Dog azorica=new Dog();
        System.out.println("\n"+ azorica.getName());

        Cooker cooker = new Cooker();
        cooker.setup();

        Filter apaNoua = new Filter();
        apaNoua.tapOn();

        Fridge fridge=new Fridge();
        fridge.openDoor();
    }

}
