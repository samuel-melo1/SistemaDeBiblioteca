package com.biblioteca.sistemadebiblioteca.config.handler;

import com.biblioteca.sistemadebiblioteca.config.exceptions.CategoriaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoriaException.class)
    private ResponseEntity<String> categoriaNotFoundHandler(CategoriaException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found!");
    }

}
