package com.step.model;

public class Employee {
    String	name;
    String	surname;
    String	birthdate;

    public Employee(){}
    public Employee(String _name, String _surname){
        name=_name;
        surname=_surname;
    }
    public Employee(String _name, String _surname, String _birthday){
        name=_name;
        surname=_surname;
        birthdate=_birthday;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getBirhtday(){
        return birthdate;
    }

}
