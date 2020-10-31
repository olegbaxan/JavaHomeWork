package com.step.Menu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    static int level=1;
    public static int optionSelect() {

            System.out.println("=====MENU======");
            System.out.println("1. Manage Person");
            System.out.println("2. Manage Flat");
            System.out.println("3. Manage Meter");
            System.out.println("4. Manage Invoice");
            System.out.println("5. Manage Service Providers");
            System.out.println("6. Exit & Close");
            int option=0;
            boolean isValid = false;
            do {
                try{
                    option=getOption();
                    isValid = true;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Please try again");
                }
            } while(!isValid);

            switch (option){
                case 1: level=2; return 0;
                case 2: return 12;
                case 3: return 13;
                case 4: return 14;
                case 5: return 15;
                case 6:return 7777;
            }

        return 0;
    }
    public static int getOption() throws Exception{
        Scanner sc = new Scanner(System.in);
        try {
            int num = sc.nextInt();
            return num;
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Data is not a number");
            throw new Exception();
        }
    }
    public static int optionPerson(){

        System.out.println("===MENU Person===");
        System.out.println("1. Add Person");
        System.out.println("2. Modify Person");
        System.out.println("3. Delete Person");
        System.out.println("4. View Person");
        System.out.println("5. Exit & Close");
        int option=0;
        boolean isValid = false;
        do {
            try{
                option=getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while(!isValid);
        switch (option){
            case 1:return 21;
            case 2:level=3; return 0;
            case 3:return 23;
            case 4:return 24;
            case 5:level =1 ;return 0;
        }
        return 0;
    }
    public static int modifyPerson(){

        System.out.println("===Select the Attribute to change===");
        System.out.println("1. Description");
        System.out.println("2. Phone");
        System.out.println("3. Mobile");
        System.out.println("4. Email");
        System.out.println("5 Exit & Close");
        int option=0;
        boolean isValid = false;
        do {
            try{
                option=getOption();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while(!isValid);
        switch (option){
            case 1:return 31;
            case 2:return 32;
            case 3:return 33;
            case 4:return 34;
            default:level=2;return 0;

        }
    }
    public static int operationMenu() {
        switch (level){
            case 1: System.out.println("Level = "+level);return optionSelect();
            case 2: System.out.println("Level = "+level);return optionPerson();
            case 3: System.out.println("Level = "+level);return modifyPerson();


            default:System.out.println("Level = "+level);return 1;

        }

    }
}
