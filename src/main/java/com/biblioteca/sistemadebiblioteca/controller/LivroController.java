package com.biblioteca.sistemadebiblioteca.controller;

import com.biblioteca.sistemadebiblioteca.dto.LivroDTO;
import com.biblioteca.sistemadebiblioteca.model.Livro;
import com.biblioteca.sistemadebiblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getBooks")
    public ResponseEntity<List<Livro>> getAllBooks(){
       List<Livro> list = service.getAllBooks();
        return ResponseEntity.ok(list); 
    }


    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity delete(@PathVariable int id_book){
        try{
            boolean bookDeleted = service.deleteBook(id_book);
            if(bookDeleted == false){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().build();
        }catch (Exception error){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
