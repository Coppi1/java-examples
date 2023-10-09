package br.com.exhibernatejpa.DAO;

import br.com.exhibernatejpa.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {

    EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");

    EntityManager entityManager = entityManFac.createEntityManager();

    public void inseriCliente(Cliente c){
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    public void excluirCliente(Cliente c){
        entityManager.getTransaction().begin();
        Cliente objetoExcluir = entityManager.find(Cliente.class, c.getId());
        entityManager.remove(objetoExcluir);
    }

}
