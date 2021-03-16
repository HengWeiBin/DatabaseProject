package com.project.stella_boutique.service.exception;

public class GetLikeErrorException extends Exception{
    public GetLikeErrorException() {
        super("Error occurred during Getting likes");
    }
}