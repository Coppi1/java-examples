package br.com.helloworld.Repositorios;

import br.com.helloworld.Entidades.Produto;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@ViewScoped
@Component
public class produtoRepositorio {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Produto produto){

        entityManager.persist(produto);

    }
}
