package com.project.stella_boutique.service.exception;

public class AddDiscountErrorException extends Exception{
    public AddDiscountErrorException() {
        super("Error occurred during adding discounts");
    }
}