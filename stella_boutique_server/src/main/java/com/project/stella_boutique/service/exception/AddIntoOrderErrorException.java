package com.project.stella_boutique.service.exception;

public class AddIntoOrderErrorException extends Exception{
    public AddIntoOrderErrorException() {
        super("Error occurred during adding item into order");
    }
}