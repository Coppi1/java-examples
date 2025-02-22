package br.com.avaliacaojpa.Controller;

import br.com.avaliacaojpa.DAO.carroDAO;
import br.com.avaliacaojpa.Entidades.Carro;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@ViewScoped
public class carroController {
    @Autowired
    private carroDAO carroDAO;

    private Carro carro = new Carro();

    public void salvar(){
        carroDAO.inserir(carro);

        carro = new Carro();

        Messages.addFlashGlobalInfo("Registro Salvo");
    }

}
