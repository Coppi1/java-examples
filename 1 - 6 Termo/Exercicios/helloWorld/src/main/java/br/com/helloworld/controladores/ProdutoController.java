package br.com.helloworld.controladores;

import br.com.helloworld.Entidades.Produto;
import br.com.helloworld.Repositorios.produtoRepositorio;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class ProdutoController {
    @Autowired
    private produtoRepositorio produtoRepositorio;

    private Produto produto = new Produto();
    public void salvar(){

        produtoRepositorio.inserir(produto);

        produto = new Produto();

        Messages.addFlashGlobalInfo("Registro Salvo!");



    }


}
