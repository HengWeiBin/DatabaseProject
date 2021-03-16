package com.project.stella_boutique.service.exception;

public class RemoveDiscountErrorException extends Exception{
    public RemoveDiscountErrorException() {
        super("Error occurred during removing discounts");
    }
}