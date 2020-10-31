package com.step;

import com.step.Menu.Menu;
import com.step.Person.PersonDataManager;

public class App {
    public static void main(String[] args) throws Exception {
        int menuSelection;
        while(1==1){
//            clearScreen();
            //System.out.println("Enter in do");
            try {
                //System.out.println("System try");
                menuSelection = Menu.operationMenu();

            }catch (Exception ex){
                throw new Exception("Enter a valid number");
            }
            System.out.println("menuSelection="+menuSelection);
            switch (menuSelection){

                case 1:Menu.optionPerson();

                case 12: break;
                case 13: break;
                case 14: break;
                case 15: break;

                case 21: System.out.println("Enter in PersonData Manager");PersonDataManager.collectPersonInfo();break;
                case 22: break;
                case 23: PersonDataManager.delete(); break;
                case 24: PersonDataManager.listPerson();break;

                case 31: PersonDataManager.modify(1);break;
                case 32: PersonDataManager.modify(2);break;
                case 33: PersonDataManager.modify(3);break;
                case 34: PersonDataManager.modify(4);break;
                case 4: break;
                case 5: break;
                case 7777: System.exit(0);

            }



        }


    }
//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

}
