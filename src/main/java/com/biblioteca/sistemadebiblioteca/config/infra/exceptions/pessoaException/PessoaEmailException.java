package com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException;

public class PessoaEmailException extends  RuntimeException {

    public PessoaEmailException(String message){
        super(message);
    }
    public PessoaEmailException(){
        super("Email já cadastrado!");
    }
}
