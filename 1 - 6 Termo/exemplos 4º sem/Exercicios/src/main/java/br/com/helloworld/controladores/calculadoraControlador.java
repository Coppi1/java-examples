package br.com.helloworld.controladores;

import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class calculadoraControlador {
    private Double num1;
    private Double num2;
    private Double res;

    public void somar(){
        res = num1 + num2;
    }

    public void subtrair(){
        res = num1 - num2;
    }


}
