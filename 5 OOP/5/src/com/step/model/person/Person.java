package com.step.model.person;

import com.step.model.things.book.Book;

public class Person {
    String fullName;
    byte year;
    String interest;

    public void sleep(){
        System.out.println("Going to sleep");
    }
    public void eat(){
        System.out.println("Eating");
    }
    public void swim(){
        System.out.println("Swimming");
    }
    public void work(){
        System.out.println("Hard-working");
    }
    public void day(){
        eat();
        work();
        Book.open();
        swim();
        sleep();
    }

}
