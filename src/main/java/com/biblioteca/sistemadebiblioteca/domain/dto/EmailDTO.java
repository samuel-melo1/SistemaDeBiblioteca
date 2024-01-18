package com.biblioteca.sistemadebiblioteca.domain.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmailDTO {

        private Integer userId;
        private String emailTo;
        private String subject;
        private String text;
}
