package com.project.stella_boutique.service.exception;

public class UpdateOrderErrorException extends Exception{
    public UpdateOrderErrorException() {
        super("Error occurred during updating orders");
    }
}