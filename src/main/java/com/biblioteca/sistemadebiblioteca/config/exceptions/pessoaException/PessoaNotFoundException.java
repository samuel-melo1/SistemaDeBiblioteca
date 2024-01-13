package com.biblioteca.sistemadebiblioteca.config.exceptions.pessoaException;

public class PessoaNotFoundException extends RuntimeException{

    public PessoaNotFoundException(String message){
        super(message);
    }

    public PessoaNotFoundException(){
        super("Not found Users!");
    }
}
