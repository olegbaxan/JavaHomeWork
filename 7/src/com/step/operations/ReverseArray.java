package com.step.operations;

import java.util.Scanner;

public class ReverseArray {
    Scanner sc = new Scanner(System.in);

    int [] numArray= new int[getArrayLenght()];

    public void arrayList(){
        for (int i=numArray.length-1;i>=0;i--){
            System.out.print(numArray[i]+" ");
        }
    }
    public void arrayFill(){
        for (int i=0;i<numArray.length;i++){
            System.out.println("Enter values in array");
            int num = sc.nextInt();
            numArray[i]=num;
        }
        arrayList();
    }
    public int getArrayLenght(){
        System.out.println("Enter number of values in array");
        int arrayLenght = sc.nextInt();
        return arrayLenght;
    }
}
