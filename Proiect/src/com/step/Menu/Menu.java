package com.step.Menu;

import java.util.Scanner;

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
            int option=getOption();

            switch (option){
                case 1: level=11; return 0;
                case 2: return 12;
                case 3: return 13;
                case 4: return 14;
                case 5: return 15;
                case 6:level =16 ;return 0;
            }

        return 0;
    }
    public static int getOption(){
        Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            return num;


    }
    public static int optionPerson(){

        System.out.println("===MENU Person===");
        System.out.println("1. Add Person");
        System.out.println("2. Modify Person");
        System.out.println("3. Delete Person");
        System.out.println("4. View Person");
        System.out.println("5. Search Person");
        System.out.println("6. Exit & Close");
        int option=getOption();
        switch (option){
            case 1:level =11; return 21;
            case 2:level =22 ;return 0;
            case 3:level =23 ;return 0;
            case 4:level =24 ;return 0;
            case 5:level =25 ;return 0;
            case 6:level =1 ;return 6;
        }
        return 0;
    }
    public static int operationMenu() {
        switch (level){
            case 1:
                System.out.println("Level = "+level);return optionSelect();
            case 11: return optionPerson();
            case 12: return optionPerson();
            case 13: return optionPerson();
            case 14: return optionPerson();
            case 15: return optionPerson();
            case 16: return 1;

            case 21: return 1;
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            default:return 1;

        }
        //return 0;
    }






//    public static int optionSelect() throws  Exception{
//
//            System.out.println("=====MENU======");
//            System.out.println("1. Manage Person");
//            System.out.println("2. Manage Flat");
//            System.out.println("3. Manage Meter");
//            System.out.println("4. Manage Invoice");
//            System.out.println("5. Manage Service Providers");
//            System.out.println("6. Exit & Close");
//            try {
//                int getOption = getOption();
//                return getOption;
//            }catch (Exception ex){
//                System.out.println(ex.getMessage());
//                throw new Exception();
//            }
//    }
//    public static int getOption() throws  Exception{
//        Scanner sc = new Scanner(System.in);
//
//        try {
//            int num = sc.nextInt();
//            return num;
//        }catch (InputMismatchException ex){
//            sc.nextLine();
//            System.out.println("Entered Data is not a number");
//            throw new Exception("Please enter a valid number");
//        }
//
//
//    }
//    public static int optionPerson() throws  Exception{
//
//        System.out.println("===MENU Person===");
//        System.out.println("1. Add Person");
//        System.out.println("2. Modify Person");
//        System.out.println("3. Delete Person");
//        System.out.println("4. View Person");
//        System.out.println("5. Search Person");
//        System.out.println("6. Exit & Close");
//
//
//
//        try {
//            int getOption = getOption();
//            return getOption+10;
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//            throw new Exception();
//        }
//    }
//    public static int operationMenu() throws Exception {
//        switch (level){
//            case 1:
//                try {
//                    return optionSelect();}catch (Exception ex){
//                    throw new Exception("Enter a valid number");
//                }
//        }
//        return 0;
//    }

}
