package com.biblioteca.sistemadebiblioteca.config.exceptions;

public class EmailExistsException extends  RuntimeException {

    public EmailExistsException(String message){
        super(message);
    }
}
