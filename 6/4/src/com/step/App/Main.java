package com.step.App;

import java.util.Scanner;
import com.step.comparator.NumbersComparator;
import com.step.comparator.NumbersComparator;
import sun.misc.Cleaner;

public class Main {
    public static void main(String[] args) {
        NumbersComparator maxmin = new NumbersComparator();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter second number: ");
        int num2 = sc.nextInt();
        maxmin.max(num1,num2);
    }

}
