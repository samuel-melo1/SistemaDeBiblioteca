package com.biblioteca.sistemadebiblioteca.infrastructure.controller;

import com.biblioteca.sistemadebiblioteca.domain.model.dto.CategoriaDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.domain.Categoria;
import com.biblioteca.sistemadebiblioteca.infrastructure.adapters.exceptions.CategoriaException;
import com.biblioteca.sistemadebiblioteca.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping("/createCategoria")
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDTO categoriaDTO){
        try {
            Categoria categoria = categoriaService.create(categoriaDTO);
            return ResponseEntity.ok(categoria);
        }catch (CategoriaException exception){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping("/getCategorias")
    public ResponseEntity<List<Categoria>> getCategorias(){
        try{
            List<Categoria> listCategoria = categoriaService.getCategorias();
            return ResponseEntity.ok(listCategoria);
        }catch (CategoriaException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
