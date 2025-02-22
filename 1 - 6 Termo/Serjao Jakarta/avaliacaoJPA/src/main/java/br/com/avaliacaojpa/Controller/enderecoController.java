package br.com.avaliacaojpa.Controller;


import br.com.avaliacaojpa.DAO.enderecoDAO;
import br.com.avaliacaojpa.Entidades.Endereco;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class enderecoController {
    @Autowired
    private enderecoDAO enderecoDAO;

    private Endereco e = new Endereco();

    public void salvar(){
        enderecoDAO.inserir(e);

        e = new Endereco();

        Messages.addFlashGlobalInfo("Registro salvo com sucesso!");
    }
}
