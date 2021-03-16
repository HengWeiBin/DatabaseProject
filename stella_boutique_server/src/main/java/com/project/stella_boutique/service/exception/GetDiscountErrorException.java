package com.project.stella_boutique.service.exception;

public class GetDiscountErrorException extends Exception{
    public GetDiscountErrorException() {
        super("Error occurred during getting discounts");
    }
}