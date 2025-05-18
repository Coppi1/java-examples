package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long codigo;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
    private LocalDate validade;
}