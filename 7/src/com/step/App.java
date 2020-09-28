package com.step;

import com.step.model.Employee;
import com.step.operations.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

//    ArraySum array1=new ArraySum();
//    array1.arrayFill();

//        ReverseArray array2 = new ReverseArray();
//        array2.arrayFill();

//        ArrayMax array3=new ArrayMax();
//        array3.arrayFill();

//        FindInt letter=new FindInt();
//        letter.arrayFill();

//        Calculator calc=new Calculator();
//        calc.sumInt(5,6);
//        calc.sumDouble(5,6);

        Employee mecanic=new Employee("Ion","Petrescu");
        Employee mecanic1=new Employee("Ion","Petrescu", "15092000");
        System.out.println("Mecanic = "+ mecanic.getName()+ " / "+ mecanic.getSurname());
        System.out.println("Mecanic1 = "+ mecanic1.getName()+ " / "+ mecanic1.getSurname()+ " / "+mecanic1.getBirhtday());
    }
}
