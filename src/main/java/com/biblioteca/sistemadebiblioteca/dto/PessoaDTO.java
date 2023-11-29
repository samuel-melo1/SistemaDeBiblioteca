package com.biblioteca.sistemadebiblioteca.dto;

import com.biblioteca.sistemadebiblioteca.Enums.PessoaRole;
import com.biblioteca.sistemadebiblioteca.model.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public record PessoaDTO(String nome,
                        String cpf,
                        LocalDate data_nascimento,
                        String email,
                        String senha,
                        PessoaRole role,
                        List<Emprestimo> emprestimo,
                        String endereco) {
}
