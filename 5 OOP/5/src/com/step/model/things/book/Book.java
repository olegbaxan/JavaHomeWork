package com.step.model.things.book;

public class Book {
    String title;
    String writer;
    int pages;
    String domain;

    public static void read(){
        System.out.println("Reading a book");
    }
    public static void open(){
        System.out.println("Tired. Open a book");
        read();
    }
}
