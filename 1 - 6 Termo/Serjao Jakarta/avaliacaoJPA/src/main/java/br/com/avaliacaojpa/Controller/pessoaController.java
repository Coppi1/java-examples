package br.com.avaliacaojpa.Controller;

import br.com.avaliacaojpa.DAO.pessoaDAO;
import br.com.avaliacaojpa.Entidades.Pessoa;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Data
@ViewScoped
public class pessoaController {

    @Autowired
    private pessoaDAO pessoaDAo;

    private Pessoa p = new Pessoa();

    public void salvar() {
        pessoaDAo.inserir(p);

        p = new Pessoa();

        Messages.addFlashGlobalInfo("Registro Salvo!");
    }
}
