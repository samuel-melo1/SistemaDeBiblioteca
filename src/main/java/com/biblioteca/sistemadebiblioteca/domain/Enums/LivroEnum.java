package com.biblioteca.sistemadebiblioteca.domain.Enums;

public enum LivroEnum {

    DISPONIVEL ("disponivel"),
    EMPRESTADO ("emprestado");

    private String status;
     LivroEnum(String status){
        this.status = status;
    }
}
