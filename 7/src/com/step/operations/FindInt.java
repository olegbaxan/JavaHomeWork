package com.step.operations;

import java.util.Scanner;

public class FindInt {
    Scanner sc = new Scanner(System.in);

    char [] charArray= new char[10];

    public void findLetterType(){

        for (int i=0;i<10;i++){
            if (Character.toLowerCase(charArray[i]) == 'a' || Character.toLowerCase(charArray[i]) == 'e' || Character.toLowerCase(charArray[i]) == 'o' || Character.toLowerCase(charArray[i])=='i'|| Character.toLowerCase(charArray[i]) =='u'){
                System.out.println(charArray[i] + " is a vowel");
            }
            else System.out.println(charArray[i] + " is a consonant");

        }
    }
    public void arrayFill(){
        for (int i=0;i<10;i++){
            System.out.println("Enter Characters in array");
            char letter = sc.nextLine().charAt(0);
            charArray[i]=letter;
        }
        findLetterType();
    }
//    public int getArrayLenght(){
//        System.out.println("Enter number of values in array");
//        int arrayLenght = sc.nextInt();
//        return arrayLenght;
//    }

}
