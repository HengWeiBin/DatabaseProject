package com.project.stella_boutique.service.exception;

public class AddProductErrorException extends Exception{
    public AddProductErrorException() {
        super("Error occurred during adding product");
    }
}