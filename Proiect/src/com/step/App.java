package com.step;

import com.step.Menu.Menu;
import com.step.Person.PersonDataManager;

public class App {
    public static void main(String[] args) throws Exception {
        while(1==1){
           int menuSelection=0;
        boolean isValid = false;
        do {
            try{
                menuSelection = Menu.operationMenu();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again");
            }
            } while(!isValid);
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


}
