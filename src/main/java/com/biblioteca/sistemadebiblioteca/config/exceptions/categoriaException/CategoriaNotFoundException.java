package com.biblioteca.sistemadebiblioteca.config.exceptions.categoriaException;

public class CategoriaNotFoundException extends  RuntimeException{

    public CategoriaNotFoundException(String message){
        super(message);
    }

    public CategoriaNotFoundException(){
        super("Categoria not found!");
    }

}
