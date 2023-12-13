package com.biblioteca.sistemadebiblioteca.controller.domainController;

import com.biblioteca.sistemadebiblioteca.model.service.EmprestimoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprestimoController {

    private EmprestimoService emprestimo;

    public EmprestimoController(EmprestimoService emprestimo){
        this.emprestimo = emprestimo;
    }

}
