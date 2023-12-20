package com.biblioteca.sistemadebiblioteca.controller.domainController;

import com.biblioteca.sistemadebiblioteca.model.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;
import com.biblioteca.sistemadebiblioteca.model.exceptions.PessoaException;
import com.biblioteca.sistemadebiblioteca.model.service.PessoaService;
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
    public ResponseEntity create(@RequestBody @Valid PessoaDTO pessoaDTO) throws EmailExistsException {
        this.pessoaService.register(pessoaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listUsers")
    public ResponseEntity<List<Pessoa>> list() {
        try {
            List<Pessoa> list = pessoaService.getAll();
            return ResponseEntity.ok(list);
        } catch (PessoaException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            boolean deletePessoa = pessoaService.deletePessoa(id);
            return new ResponseEntity(deletePessoa, HttpStatus.OK);
        }catch (PessoaException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
