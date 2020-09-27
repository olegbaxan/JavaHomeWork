package com.step.comparator;

public class NumbersComparator {
    public void max(int firstNumber, int secondNumber){
        if(firstNumber>secondNumber)
        {
            System.out.println("Number "+ firstNumber+ " is the Maximum");
        }
        else if(firstNumber<secondNumber) System.out.println("Number "+ secondNumber+ " is the Maximum");
        else System.out.println("Numbers are equals");
    }
    public void min(int firstNumber, int secondNumber){
        if(firstNumber<secondNumber)
        {
            System.out.println("Number "+ firstNumber+ " is the Minimum");
        }
        else if(firstNumber<secondNumber)
            System.out.println("Number "+ secondNumber+ " is the Minimum");
        else System.out.println("Numbers are equals");
    }
}
