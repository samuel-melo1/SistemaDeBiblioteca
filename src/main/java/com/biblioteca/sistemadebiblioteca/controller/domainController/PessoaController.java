package com.biblioteca.sistemadebiblioteca.controller.domainController;

import com.biblioteca.sistemadebiblioteca.model.dto.PessoaDTO;
import com.biblioteca.sistemadebiblioteca.model.exceptions.EmailExistsException;
import com.biblioteca.sistemadebiblioteca.model.domain.Pessoa;
import com.biblioteca.sistemadebiblioteca.model.service.PessoaService;
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
    @DeleteMapping("/deleteUsers/{id}")
    public ResponseEntity delete(@PathVariable int id){
        try{
            boolean pessoaDeletada = pessoaService.deletePessoa(id);
            if(pessoaDeletada == false){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().build();
        }catch (Exception error){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
