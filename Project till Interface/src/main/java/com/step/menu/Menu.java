package com.step.menu;

import com.step.exception.NumberNotValidException;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public static MenuOption optionSelect() {

        System.out.println("=====MENU======");
        System.out.println("1. Manage Person");
        System.out.println("2. Manage Flat");
        System.out.println("3. Manage Meter");
        System.out.println("4. Manage Invoice");
        System.out.println("5. Manage Service Providers");
        System.out.println("6. Exit & Close");
        int option = 0;
        boolean isValid = false;
        do {
            try {
                option = getOption();
                isValid = true;
            } catch (NumberNotValidException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);

        switch (option) {
            case 1:
                return MenuOption.PERSON_MENU;
            case 2:
                return MenuOption.FLAT_MENU;
            case 3:
                return MenuOption.METER_MENU;
            case 4:
                return MenuOption.INVOICE_MENU;
            case 5:
                return MenuOption.SERVICE_PROVIDERS_MENU;
            case 6:
                return MenuOption.EXIT;
            default:return MenuOption.MAIN_MENU;
        }
    }

    public static int getOption() throws NumberNotValidException {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException ex) {
            sc.nextLine();
            System.out.println("Data is not a number");
            throw new NumberNotValidException();
        }
    }

    public static MenuOption optionPerson() {

        System.out.println("===MENU Person===");
        System.out.println("1. Add Person");
        System.out.println("2. Modify Person");
        System.out.println("3. Delete Person");
        System.out.println("4. View Person");
        System.out.println("5. Search Person");
        System.out.println("6. Save Person Data to CSV");
        System.out.println("7. Exit & Close");
        int option = 0;
        boolean isValid = false;
        do {
            try {
                option = getOption();
                isValid = true;
            } catch (NumberNotValidException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);
        switch (option) {
            case 1:
                return MenuOption.ADD_PERSON;
            case 2:
                return MenuOption.MODIFY_PERSON;
            case 3:
                return MenuOption.DELETE_PERSON;
            case 4:
                return MenuOption.VIEW_PERSON;
            case 5:
                return MenuOption.SEARCH_PERSON;
            case 6:
                return MenuOption.SAVE_PERSON_TO_CSV;
            case 7:
                return MenuOption.MAIN_MENU;
            default:return MenuOption.PERSON_MENU;
        }
    }

    public static MenuOption modifyPerson() {

        System.out.println("===Select the Attribute to change===");
        System.out.println("1. Description");
        System.out.println("2. Phone");
        System.out.println("3. Mobile");
        System.out.println("4. Email");
        System.out.println("5 Exit & Close");
        int option = 0;
        boolean isValid = false;
        do {
            try {
                option = getOption();
                isValid = true;
            } catch (NumberNotValidException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);
        switch (option) {
            case 1:
                return MenuOption.MODIFY_PERSON_DESC;
            case 2:
                return MenuOption.MODIFY_PERSON_PHONE;
            case 3:
                return MenuOption.MODIFY_PERSON_MOBIL;
            case 4:
                return MenuOption.MODIFY_PERSON_EMAIL;
            case 5:
                return MenuOption.PERSON_MENU;
            default:
                return MenuOption.MODIFY_PERSON;

        }
    }

    public static MenuOption searchPersonBy() {

        System.out.println("===Search By===");
        System.out.println("1. IDNP");
        System.out.println("2. Surname");
        System.out.println("3. Phone");
        System.out.println("4. Mobil");
        System.out.println("5 Exit & Close");
        int option = 0;
        boolean isValid = false;
        do {
            try {
                option = getOption();
                isValid = true;
            } catch (NumberNotValidException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
        } while (!isValid);
        switch (option) {
            case 1:
                return MenuOption.SEARCH_PERSON_BY_IDNP;
            case 2:
                return MenuOption.SEARCH_PERSON_BY_SURNAME;
            case 3:
                return MenuOption.SEARCH_PERSON_BY_PHONE;
            case 4:
                return MenuOption.SEARCH_PERSON_BY_MOBIL;
            case 5:
                return MenuOption.PERSON_MENU;
            default:
                return MenuOption.SEARCH_PERSON;

        }
    }
}
