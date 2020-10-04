package com.step;

import com.step.model.Employee;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//    Exercițiu practic #3
        int empQuantity=5;
        Employee[] emp2 = new Employee[empQuantity];
        emp2[0] = new Employee("Ion");
        emp2[1] = new Employee("Vasile");
        emp2[2] = new Employee("Petru");
        emp2[3] = new Employee("Marin");
        emp2[4] = new Employee("Sergiu");

        int orderNumber=Employee.order();
        try {
            emp2[orderNumber-1].listEmployee();
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Element does not exist. Please enter a value between 1 and "+empQuantity);
        }


        //    Exercițiu practic #2
        Employee emp1=new Employee();
        emp1.enterText();

    }


}
