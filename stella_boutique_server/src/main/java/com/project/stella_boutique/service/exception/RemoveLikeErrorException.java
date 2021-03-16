package com.project.stella_boutique.service.exception;

public class RemoveLikeErrorException extends Exception{
    public RemoveLikeErrorException() {
        super("Error occurred during Removing likes");
    }
}