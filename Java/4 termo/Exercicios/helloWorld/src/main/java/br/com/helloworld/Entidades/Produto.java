package br.com.helloworld.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@Component
@ViewScoped
@Data

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;
    private String nome;
    private Integer qtd;
    private double preco;
    private LocalDate validade;
}
