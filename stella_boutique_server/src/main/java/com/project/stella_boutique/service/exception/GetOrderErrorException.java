package com.project.stella_boutique.service.exception;

public class GetOrderErrorException extends Exception{
    public GetOrderErrorException() {
        super("Error occurred during getting orders");
    }
}