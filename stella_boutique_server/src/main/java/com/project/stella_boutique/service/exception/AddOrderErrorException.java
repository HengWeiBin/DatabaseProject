package com.project.stella_boutique.service.exception;

public class AddOrderErrorException extends Exception{
    public AddOrderErrorException() {
        super("Error occurred during adding order");
    }
}