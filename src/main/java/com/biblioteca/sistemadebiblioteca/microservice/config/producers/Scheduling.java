package com.biblioteca.sistemadebiblioteca.microservice.config.producers;

import com.biblioteca.sistemadebiblioteca.domain.dto.EmailDTO;
import com.biblioteca.sistemadebiblioteca.domain.model.Emprestimo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;


@EnableScheduling
public class Scheduling {
    @Scheduled(cron = "0 0 6")
    public void verifyDeadline(Emprestimo emprestimo){
        if(emprestimo.getPrazo().equals(LocalDate.now())){
            var emailDto = new EmailDTO();
            emailDto.setUserId(emprestimo.getPessoa().getId_pessoa());
            emailDto.setEmailTo(emprestimo.getPessoa().getEmail());
            emailDto.setSubject("Lembrete: Devolução de Livro em Breve - " + emprestimo.getLivro().getTitulo());
            emailDto.setText("Prezado(a) " + emprestimo.getPessoa().getNome() +
                    ",\n\nEste é um lembrete amigável de que o livro que você pegou emprestado, intitulado \"" +
                    emprestimo.getLivro().getTitulo() + "\", está prestes a vencer. Pedimos a gentileza de devolvê-lo até a data de vencimento para evitar possíveis penalidades.\n\n" +
                    "Detalhes do Empréstimo:\n" +
                    "- Título do Livro: " + emprestimo.getLivro().getTitulo() + "\n" +
                    "- Data de Empréstimo: " + emprestimo.getData_emprestimo() + "\n" +
                    "- Data de Vencimento: " + emprestimo.getPrazo() + "\n\n" +
                    "Agradecemos pela sua atenção e cooperação.");

        }
    }
}
