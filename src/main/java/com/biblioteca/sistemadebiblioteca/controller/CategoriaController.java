package com.biblioteca.sistemadebiblioteca.controller;

import com.biblioteca.sistemadebiblioteca.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.model.Categoria;
import com.biblioteca.sistemadebiblioteca.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/createCategoria")
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDTO categoriaDTO){
       Categoria categoria = categoriaService.create(categoriaDTO);
        return ResponseEntity.ok(categoria);

    }
}
