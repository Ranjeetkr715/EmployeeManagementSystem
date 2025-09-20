package com.ranjeetgit.ems.exception;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(){}

    public DepartmentNotFoundException(String message){
        super(message);
    }
}
