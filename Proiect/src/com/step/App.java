package com.step;

import com.step.manager.IPersonManager;
import com.step.manager.PersonManagerDB;
import com.step.manager.PersonManagerInFile;
import com.step.manager.PersonManagerInMemory;
import com.step.menu.Menu;
import com.step.menu.MenuOption;
import com.step.person.Person;
import com.step.read.ReadObjectPersonData;
//import com.step.read.ReadPersonDataFromFile;
import com.step.write.WriteObjectPersonData;
import com.step.write.WritePersonDataToFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        List <Person> person = new ArrayList<>();
        // citim optiunea
        System.out.println("Please select type of Data to work with");
        System.out.println("Press 1 - for In Memory");
        System.out.println("Press 2 - for In File");
        System.out.println("Press 3 - for In DB");
        int option = (new Scanner(System.in)).nextInt();
        IPersonManager personManager = null;

        switch(option) {
            case 1: {
                personManager = new PersonManagerInMemory();
                break;
            }
            case 2: {
                personManager = new PersonManagerInFile();
                person = ReadObjectPersonData.ReadObjectPersonFromFile();
                //ReadPersonDataFromFile.readPersonFromFile();
                break;
            }
            case 3: {
                personManager = new PersonManagerDB();
                break;
            }
        }



        MenuOption menuSelection= MenuOption.MAIN_MENU;

        while (true) {
            switch (menuSelection) {
                case MAIN_MENU: {
                    menuSelection =Menu.optionSelect();
                    break;
                }
                case PERSON_MENU: {
                    menuSelection =Menu.optionPerson();
                    break;
                }
//              case FLAT_MENU:
//              case METER_MENU:
//              case INVOICE_MENU:
//              case SERVICE_PROVIDERS_MENU:
                case SEARCH_PERSON_BY_IDNP: {
                    personManager.search(1,person);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_SURNAME: {
                    personManager.search(2, person);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_PHONE: {
                    personManager.search(3, person);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_MOBIL: {
                    personManager.search(4, person);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case ADD_PERSON: {
                    personManager.add(person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON: {
                    menuSelection = Menu.modifyPerson();
                    break;
                }
                case DELETE_PERSON: {
                    personManager.delete(person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case VIEW_PERSON: {
                    personManager.listPerson(person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case SEARCH_PERSON: {
                    menuSelection = Menu.searchPersonBy();
                    break;
                }
                case SAVE_PERSON_TO_CSV: {
                    WritePersonDataToFile.savePersonDataToFile();
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_DESC: {
                    personManager.modify(1,person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_PHONE: {
                    personManager.modify(2,person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_MOBIL: {
                    personManager.modify(3,person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_EMAIL: {
                    personManager.modify(4,person);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case EXIT: {
//                    WriteObjectPersonData.WriteObjectPersonDataToFile(person);
                    personManager.close(person);
                    System.exit(0);
                }

            }
        }
    }
}
