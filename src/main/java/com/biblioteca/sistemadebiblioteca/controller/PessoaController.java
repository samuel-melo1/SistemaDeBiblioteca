package com.biblioteca.sistemadebiblioteca.controller;

import com.biblioteca.sistemadebiblioteca.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaController {

    private PessoaService pessoaService;

    PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid PessoaDTO pessoaDTO) throws EmailExistsException {
         this.pessoaService.register(pessoaDTO);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<Pessoa>> list(){
        try{
            List<Pessoa> list = pessoaService.getAll();

            if(list.isEmpty()){ return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
