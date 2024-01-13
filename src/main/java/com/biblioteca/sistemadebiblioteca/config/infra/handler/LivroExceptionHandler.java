package com.biblioteca.sistemadebiblioteca.config.infra.handler;

import com.biblioteca.sistemadebiblioteca.config.exceptions.livroException.LivroExistsException;
import com.biblioteca.sistemadebiblioteca.config.exceptions.livroException.LivroNotFoundException;
import com.biblioteca.sistemadebiblioteca.config.infra.responsehandler.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LivroExceptionHandler {

    @ExceptionHandler(LivroNotFoundException.class)
    public ResponseEntity<RestErrorMessage> livroNotFoundException(LivroNotFoundException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(LivroExistsException.class)
    public ResponseEntity<RestErrorMessage> livroExistsException(LivroExistsException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }
}
