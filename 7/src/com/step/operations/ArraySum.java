package com.step.operations;
import java.util.Scanner;

public class ArraySum {
    Scanner sc = new Scanner(System.in);

    int [] numArray= new int[getArrayLenght()];

    public void arraySum(){
        int sum=0;
        for (int i=0;i<numArray.length;i++){

            sum+=numArray[i];
        }
        System.out.println("Sum of array is " +sum);
    }
    public void arrayFill(){
        for (int i=0;i<numArray.length;i++){
            System.out.println("Enter values in array");
            int num = sc.nextInt();
            numArray[i]=num;
        }
        arraySum();
    }
    public int getArrayLenght(){
        System.out.println("Enter number of values in array");
        int arrayLenght = sc.nextInt();
        return arrayLenght;
    }
}
