package br.com.avaliacaojpa.DAO;

import br.com.avaliacaojpa.Entidades.Endereco;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class enderecoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Endereco endereco){

        entityManager.persist(endereco);
    }
}
