package com.step.App;

import java.util.Scanner;
import com.step.calculator.Calculator;
import sun.misc.Cleaner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        Scanner sc = new Scanner(System.in);
        System.out.println("Rezultat = " +(3+3*3+3));
//        System.out.println("Choose type of operation \"+\" - Sum, \"-\" - Minus, \"*\" - Multiply, \"/\" - Divide: ");
//        char ch= sc.nextLine().charAt(0);
//        System.out.println("Enter first number: ");
//        int num1 = sc.nextInt();
//        System.out.println("Enter second number: ");
//        int num2 = sc.nextInt();
//        switch (ch){
//            case '+' : calc.sum(num1,num2);break;
//            case '-' : calc.minus(num1,num2);break;
//            case '*' : calc.multiply(num1,num2);break;
//            case '/' : calc.divide(num1,num2);break;
//        }
    }

}
