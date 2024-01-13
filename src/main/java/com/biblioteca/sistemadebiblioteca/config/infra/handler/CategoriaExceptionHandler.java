package com.biblioteca.sistemadebiblioteca.config.infra.handler;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException.CategoriaExistException;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.categoriaException.CategoriaNotFoundException;
import com.biblioteca.sistemadebiblioteca.config.infra.responsehandler.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CategoriaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoriaNotFoundException.class)
    private ResponseEntity<RestErrorMessage> categoriaNotFoundHandler(CategoriaNotFoundException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(CategoriaExistException.class)
    private ResponseEntity<RestErrorMessage> categoriaExistHandler(CategoriaExistException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }

}
