package br.com.avaliacaojpa.Entidades;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;


@ViewScoped
@Component
@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private Integer num;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;
    private String complemento;
}
