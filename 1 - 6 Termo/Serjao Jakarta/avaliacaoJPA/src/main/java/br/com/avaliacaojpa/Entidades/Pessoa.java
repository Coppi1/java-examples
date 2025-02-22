package br.com.avaliacaojpa.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Component
@ViewScoped
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dtNascimento;
}
