package com.biblioteca.sistemadebiblioteca.controller;

import com.biblioteca.sistemadebiblioteca.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.model.Livro;
import com.biblioteca.sistemadebiblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class LivroController {

    private LivroService service;

    public LivroController(LivroService service){
        this.service = service;
    }
    @PostMapping("/createBook")
    public ResponseEntity<Livro> createBook(@RequestBody @Valid LivroDTO livroDTO){
        this.service.createBook(livroDTO);
        return new ResponseEntity(livroDTO,HttpStatus.OK);
    }
}
