package com.biblioteca.sistemadebiblioteca.domain.interfaces;

import com.biblioteca.sistemadebiblioteca.domain.dto.EmailDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;

public interface EmailBodyImpl {

    public EmailDTO sentEmail(Emprestimo emprestimo);
}
