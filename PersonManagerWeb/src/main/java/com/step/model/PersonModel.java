package edu.step.model;

import edu.step.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonModel {
    private static PersonModel instance = new PersonModel();

    public static PersonModel getInstance() {
        return instance;
    }



    private List<Person> personList;
    private PersonModel() {
        this.personList = new ArrayList<>();
    }
    public boolean add(Person per) {
        return this.personList.add(per);
    }
    public List<String> list() {
        return personList.stream().map(user -> user.getName()).collect(Collectors.toList());
    }

    public void deletePerson(int position) {
        this.personList.remove(position);
    }

    public Person get(int position) {
        return this.personList.get(position);
    }

    public void edit(int position, String newName) {
        this.personList.get(position).setName(newName);
    }

}
