package com.step;

import com.step.Menu.Menu;
import com.step.Person.PersonDataManager;

public class App {
    public static void main(String[] args) throws Exception {
        int menuSelection;
        while(1==1){
            clearScreen();
            System.out.println("Enter in do");
            try {
                System.out.println("System try");
                menuSelection = Menu.operationMenu();

            }catch (Exception ex){
                throw new Exception("Enter a valid number");
            }
            System.out.println("menuSelection="+menuSelection);
            switch (menuSelection){

                case 1:Menu.optionPerson();
                   // System.out.println("You selected Manage Person");
                case 21: PersonDataManager.add();
                    System.out.println("Enter in PersonData Manager");break;
                case 22:                    break;
                case 23:                    break;
                case 24:                    break;
                case 25:                    break;
                case 26:                    break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: System.exit(0);
            }



        }


    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
