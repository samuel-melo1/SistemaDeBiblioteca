package com.biblioteca.sistemadebiblioteca.controller;

import com.biblioteca.sistemadebiblioteca.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
