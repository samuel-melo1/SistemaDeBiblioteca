package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException;

public class CategoriaNotFoundException extends  RuntimeException{

    public CategoriaNotFoundException(String message){
        super(message);
    }

    public CategoriaNotFoundException(){
        super("Categoria não encontrada!");
    }

}
