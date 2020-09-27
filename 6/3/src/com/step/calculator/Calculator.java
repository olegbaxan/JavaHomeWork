package com.step.calculator;

public class Calculator {
    public void sum(int firstNumber, int secondNumber){
        System.out.println("Sum is "+ (firstNumber+secondNumber));
    }
    public void minus(int firstNumber, int secondNumber){
        System.out.println("Minus is "+ (firstNumber-secondNumber));
    }
    public void multiply(int firstNumber, int secondNumber){
        System.out.println("Multiply is "+ (firstNumber*secondNumber));
    }
    public void divide(int firstNumber, int secondNumber){
        System.out.println("Division is "+ ((double)firstNumber/secondNumber));
    }
}
