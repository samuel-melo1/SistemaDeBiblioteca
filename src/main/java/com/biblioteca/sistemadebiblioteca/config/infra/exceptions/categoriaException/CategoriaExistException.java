package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException;

public class CategoriaExistException extends  RuntimeException {

    public CategoriaExistException(String message){
        super(message);
    }

    public CategoriaExistException(){
        super("Categoria já existe!");
    }


}
