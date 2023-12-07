package com.biblioteca.sistemadebiblioteca.model.exceptions;

public class EmailExistsException extends  Exception {

    public EmailExistsException(String message){
        super(message);
    }
}
