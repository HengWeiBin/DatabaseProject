package com.project.stella_boutique.service.exception;

public class UpdateDiscountErrorException extends Exception{
    public UpdateDiscountErrorException() {
        super("Error occurred during updating discounts");
    }
}