package com.step.exception;

public class NumberNotValidException extends Exception{
    public NumberNotValidException(){
        super("Exception: Entered data is not a number");
    }
}
