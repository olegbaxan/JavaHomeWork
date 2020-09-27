package com.step.App;

import java.util.Scanner;
import com.step.converter.TempConverter;
import sun.misc.Cleaner;

public class Main {
    public static void main(String[] args) {
        TempConverter tempMeasure = new TempConverter();

        Scanner sc = new Scanner(System.in);
        char ch;
            System.out.println("Choose type of Convertion C - to Celsius, F - to Fahrengate: ");
            ch = sc.nextLine().charAt(0);

            if (ch == 'C') {
                System.out.print("Enter value in Fahr to convert to Celsius: ");
                double numDouble = sc.nextDouble();  // double
                tempMeasure.convertToCelsius(numDouble);
            } else if(ch=='F'){
                System.out.print("Enter value in Celsius to convert to Fahr: ");
                double numDouble = sc.nextDouble();  // double
                tempMeasure.convertToFahr(numDouble);
            }
            else {
                //Clear screen
            System.out.print("Please enter a valid value \"C\" or \"F\"\n");}

    }

}
