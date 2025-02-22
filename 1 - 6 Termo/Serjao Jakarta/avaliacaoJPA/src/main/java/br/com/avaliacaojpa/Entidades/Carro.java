package br.com.avaliacaojpa.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@ViewScoped
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;
    private String marca;
    private String modelo;
    private Integer ano_fab;
    private Integer ano_mod;
    private double valor;
}
