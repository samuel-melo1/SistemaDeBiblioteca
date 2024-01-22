package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.domain.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Livro;
import com.biblioteca.sistemadebiblioteca.domain.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class LivroController {

    private LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping("/createBook")
    public ResponseEntity<Livro> createBook(@RequestBody @Valid LivroDTO livroDTO) {
        this.service.createBook(livroDTO);
        return new ResponseEntity(livroDTO, HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Livro>> getAllBooks() {
        List<Livro> list = service.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        service.deleteBook(id);
        return ResponseEntity.ok().build();

    }
    @PatchMapping("/updateBook/{id_book}")
    public ResponseEntity updateBook(@PathVariable("id_book") int id_book){
        this.service.updateStatusBook(id_book);
        return ResponseEntity.ok().build();
    }
}
