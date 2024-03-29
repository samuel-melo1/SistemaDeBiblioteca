package com.biblioteca.sistemadebiblioteca;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library API", version = "1.0",description = "Library Management System"))
@EnableScheduling
public class SistemaDeBibliotecaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaDeBibliotecaApplication.class, args);
    }
}
