package com.company;

public class FullArrayException extends Exception {
    //ListArray가 full일 때 발생함
    FullArrayException(){super("list is full..\nhow much will it expand?");}
    FullArrayException(String exception){
        super(exception);
    }
}

