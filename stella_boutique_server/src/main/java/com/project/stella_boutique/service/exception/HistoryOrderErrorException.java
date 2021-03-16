package com.project.stella_boutique.service.exception;

public class HistoryOrderErrorException extends Exception{
    public HistoryOrderErrorException() {
        super("Error occurred during getting order history");
    }
}