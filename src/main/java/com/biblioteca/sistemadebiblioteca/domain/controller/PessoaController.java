package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.domain.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Pessoa;
import com.biblioteca.sistemadebiblioteca.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PessoaController {

    private PessoaService pessoaService;

    PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        this.pessoaService.register(pessoaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<Pessoa>> list() {
        List<Pessoa> list = pessoaService.getAll();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deletePessoa = pessoaService.deletePessoa(id);
        return new ResponseEntity(deletePessoa, HttpStatus.OK);
    }
}
