package com.biblioteca.sistemadebiblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pessoa;

    private String nome;
    private String cpf;
    private String endereco;
    private LocalDate data_nascimento;
    @OneToMany(mappedBy = "pessoa")
    @JoinColumn(name="emprestimo_id")
    private List<Emprestimo> emprestimo;



}
