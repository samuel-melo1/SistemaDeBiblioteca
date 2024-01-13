package com.biblioteca.sistemadebiblioteca.config.infra.handler;

import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaEmailException;
import com.biblioteca.sistemadebiblioteca.config.infra.exceptions.pessoaException.PessoaNotFoundException;
import com.biblioteca.sistemadebiblioteca.config.infra.responsehandler.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PessoaExceptionHandler {

    @ExceptionHandler(PessoaNotFoundException .class)
    private ResponseEntity<RestErrorMessage> pessoaNotFoundHandler(PessoaNotFoundException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(PessoaEmailException.class)
    private ResponseEntity<RestErrorMessage> pessoaExistsEmailHandler(PessoaEmailException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMessage);
    }

}
