package com.project.stella_boutique.service.exception;

public class LoginErrorException extends Exception{
    public LoginErrorException() {
        super("Can't login");
    }
}