package com.biblioteca.sistemadebiblioteca.domain.controller;

import com.biblioteca.sistemadebiblioteca.domain.model.entity.Emprestimo;
import com.biblioteca.sistemadebiblioteca.domain.model.dto.EmprestimoDTO;
import com.biblioteca.sistemadebiblioteca.domain.service.EmprestimoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/emprestimo")
public class EmprestimoController {

    private EmprestimoService emprestimo;

    public EmprestimoController(EmprestimoService emprestimo) {
        this.emprestimo = emprestimo;
    }

    @PostMapping("/emprestar")
    public ResponseEntity<Emprestimo> emprestar(@RequestBody EmprestimoDTO emprestimoDTO) {
        var emprestimo = new Emprestimo();
        BeanUtils.copyProperties(emprestimoDTO, emprestimo);
        this.emprestimo.emprestar(emprestimo);
        return new ResponseEntity(emprestimoDTO, HttpStatus.OK);
    }
}
