package com.project.stella_boutique.service.exception;

public class UpdateProductErrorException extends Exception{
    public UpdateProductErrorException() {
        super("Error occurred during updating products");
    }
}