package md.step;

import md.step.ArrayList.Colors;
import md.step.ArrayList.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Colors> colorList=new ArrayList<Colors>();

        //1.
        System.out.println("=======Start of point 1");
        colorList.add(new Colors("White"));
        colorList.add(new Colors("Red"));
        colorList.add(new Colors("Black"));
        colorList.add(new Colors("Yellow"));
        colorList.add(new Colors("Blue"));

        for(Colors c: colorList){
            System.out.println(c.getColor());
        }
        System.out.println("=======End of point 1");
        System.out.println("=======Start of point 2");

        List<Colors> arrList10Elements=new ArrayList<Colors>();
        for (int i=0;i<10;i++){
            arrList10Elements.add(0,new Colors("10ValueArray"+(i+1)));
        }
        for(Colors c10: arrList10Elements){
            System.out.println(c10.getColor());
        }
        System.out.println("=======End of point 2");
        System.out.println("=======Start of point 3");
        System.out.println("Element number 5 is : " + arrList10Elements.get(5).getColor());
        System.out.println("=======End of point 3");

        System.out.println("=======Start of point 4");
        List<Colors> colorListNr1=new ArrayList<Colors>();
        List<Colors> colorListNr2=new ArrayList<Colors>();
        colorListNr1.add(new Colors("White"));
        colorListNr1.add(new Colors("Red"));
        colorListNr2.add(new Colors("Black"));
        colorListNr2.add(new Colors("Yellow"));
        int j=0;
        int size=colorListNr1.size()+colorListNr2.size();
        for (int i=colorListNr1.size();i<size;i++){
            colorListNr1.add(i,colorListNr2.get(j));
            j++;
        }
        for(Colors cList1: colorListNr1){
            System.out.println(cList1.getColor());
        }
        System.out.println("=======End of point 4");
        System.out.println("=======Start of point 5");
        List<Person> person=new ArrayList<>();
        List<String> personString = new ArrayList<>();
        personString.add("Ruslan");
        personString.add("Marin");

        person.add(new Person("Ion"));
        person.add(new Person("Sergiu"));
        person.add(new Person("Nicolae"));
        person.add(new Person("Petru"));

        boolean per = person.contains(new Person("Ion"));//Search for Ion in the ArrayList of type Person

        boolean persStr = personString.contains("Marin");
        
        Integer pers = person.indexOf(new Person("Nicolae1"));//suprascriere in clasa Person a equals()

        System.out.println("Found for Ion = " + persStr);
        System.out.println("=======End of point 5");



    }

}
