package com.project.stella_boutique.service.exception;

public class CancelOrderErrorException extends Exception{
    public CancelOrderErrorException() {
        super("Error occurred during cancelling order");
    }
}