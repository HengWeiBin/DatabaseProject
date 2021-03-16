package com.project.stella_boutique.service.exception;

public class GetProductErrorException extends Exception{
    public GetProductErrorException() {
        super("Error occurred during getting products");
    }
}