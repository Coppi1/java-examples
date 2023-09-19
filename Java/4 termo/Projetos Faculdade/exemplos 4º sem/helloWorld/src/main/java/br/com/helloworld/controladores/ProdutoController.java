package br.com.helloworld.controladores;

import br.com.helloworld.Entidades.Produto;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class ProdutoController {

    private Produto produto = new Produto();


    public void salvar(){
        Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
    }


}
