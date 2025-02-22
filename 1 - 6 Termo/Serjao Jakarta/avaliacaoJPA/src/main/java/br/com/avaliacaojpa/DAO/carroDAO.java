package br.com.avaliacaojpa.DAO;


import br.com.avaliacaojpa.Entidades.Carro;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class carroDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserir(Carro carro){
        entityManager.persist(carro);
    }
}
