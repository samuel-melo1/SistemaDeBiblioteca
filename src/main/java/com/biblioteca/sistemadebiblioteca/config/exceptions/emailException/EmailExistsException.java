package com.biblioteca.sistemadebiblioteca.config.exceptions.emailException;

public class EmailExistsException extends  RuntimeException {

    public EmailExistsException(String message){
        super(message);
    }
}
