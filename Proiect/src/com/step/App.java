package com.step;

import com.step.menu.Menu;
import com.step.menu.MenuOption;
import com.step.person.PersonDataManager;

public class App {
    public static void main(String[] args){
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
                    PersonDataManager.search(1);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_SURNAME: {
                    PersonDataManager.search(2);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_PHONE: {
                    PersonDataManager.search(3);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case SEARCH_PERSON_BY_MOBIL: {
                    PersonDataManager.search(4);
                    menuSelection = MenuOption.SEARCH_PERSON;
                    break;
                }
                case ADD_PERSON: {
                    PersonDataManager.collectPersonInfo();
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON: {
                    menuSelection = Menu.modifyPerson();
                    break;
                }
                case DELETE_PERSON: {
                    PersonDataManager.delete();
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case VIEW_PERSON: {
                    PersonDataManager.listPerson();
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case SEARCH_PERSON: {
                    menuSelection = Menu.searchPersonBy();
                    break;
                }
                case MODIFY_PERSON_DESC: {
                    PersonDataManager.modify(1);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_PHONE: {
                    PersonDataManager.modify(2);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_MOBIL: {
                    PersonDataManager.modify(3);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case MODIFY_PERSON_EMAIL: {
                    PersonDataManager.modify(4);
                    menuSelection = MenuOption.PERSON_MENU;
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }

            }
        }
    }
}
