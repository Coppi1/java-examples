package soapCrudExample.Models;

import lombok.*;
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