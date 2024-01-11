package com.biblioteca.sistemadebiblioteca.config.exceptions;

public class CategoriaException extends  RuntimeException{

    public CategoriaException(String message){
        super(message);
    }

    public CategoriaException(){
         super();
    }
}
