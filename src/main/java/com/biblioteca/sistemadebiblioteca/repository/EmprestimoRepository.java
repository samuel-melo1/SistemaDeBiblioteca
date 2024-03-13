package com.biblioteca.sistemadebiblioteca.repository;

import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    @Query(value = "select emprestimo.* from emprestimo " +
                    "left join livro on (livro.id_livro = emprestimo.id_livro) " +
                    "where livro.status = 1  ", nativeQuery = true)
    List<Emprestimo> buscarEmprestimo();


}
