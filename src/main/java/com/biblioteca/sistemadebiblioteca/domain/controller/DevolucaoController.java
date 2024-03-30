package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.domain.service.DevolucaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class DevolucaoController {

    private DevolucaoService devolucaoService;

    public DevolucaoController(DevolucaoService devolucaoService){
        this.devolucaoService = devolucaoService;
    }

    @PostMapping("/devolucao/{id_livro}")
    public ResponseEntity askDevolution(@PathVariable("id_livro") Integer id_livro){
        return new ResponseEntity<>(devolucaoService.askDevolution(id_livro), HttpStatus.OK);
    }
}
