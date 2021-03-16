package com.project.stella_boutique.service.exception;

public class RemoveFromOrderErrorException extends Exception{
    public RemoveFromOrderErrorException() {
        super("Error occurred during removing item from order");
    }
}