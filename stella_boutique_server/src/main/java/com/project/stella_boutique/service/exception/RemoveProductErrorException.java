package com.project.stella_boutique.service.exception;

public class RemoveProductErrorException extends Exception{
    public RemoveProductErrorException() {
        super("Error occurred during removing products");
    }
}