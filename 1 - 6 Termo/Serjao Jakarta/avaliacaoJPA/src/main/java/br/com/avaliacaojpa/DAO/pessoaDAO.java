package br.com.avaliacaojpa.DAO;

import br.com.avaliacaojpa.Entidades.Pessoa;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@ViewScoped
@Component
public class pessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Pessoa pessoa){
        entityManager.persist(pessoa);
    }
}
