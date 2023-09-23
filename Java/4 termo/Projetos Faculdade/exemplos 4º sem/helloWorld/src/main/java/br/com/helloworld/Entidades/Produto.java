package br.com.helloworld.Entidades;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
@ViewScoped
@Data
public class Produto {
    private Integer cod;
    private String nome;
    private Integer qtd;
    private double preco;
    private LocalDate validade;
}
