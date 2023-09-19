package br.com.exhibernatejpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Cliente;

public class AplicacaoMain {
    public static void main(String[] args) {
        System.out.println("Iniciando APP");
        Cliente c = new Cliente();
        c.setNome("jorgin");
        c.setEmail("teste2@gmail.com");
        EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManFac.createEntityManager();
        // Iniciando a transação com o banco de dados
        entityManager.getTransaction().begin();

        // Persistindo (gravando) o objeto c no banco de dados
        //entityManager.persist(c);

        //Fazendo busca no BD
        Cliente clibusca = entityManager.find(Cliente.class, 2);
        System.out.println("Cliente encontrado: " + clibusca.getNome());

        // alterando dados do clibusca (cliente id 2)
        clibusca.setNome("Jorgin 2.0");

        //excluindo o cliente id 2 (clibusca)
        entityManager.remove(clibusca);

        // "comitando" (efetivando/enviando) a atualização no BD
        entityManager.getTransaction().commit();
        // Finalizando as comunicações com BD
        entityManager.close();
        entityManFac.close();

    }
}
