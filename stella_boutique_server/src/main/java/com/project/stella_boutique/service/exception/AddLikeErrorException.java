package com.project.stella_boutique.service.exception;

public class AddLikeErrorException extends Exception{
    public AddLikeErrorException() {
        super("Error occurred during adding likes");
    }
}