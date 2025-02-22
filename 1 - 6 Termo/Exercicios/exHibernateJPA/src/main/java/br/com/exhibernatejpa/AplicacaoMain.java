package br.com.exhibernatejpa;

import br.com.exhibernatejpa.DAO.ClienteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import br.com.exhibernatejpa.model.Cliente;

import java.util.List;

public class AplicacaoMain {
    public static void main(String[] args) {
        System.out.println("Iniciando APP");
        Cliente c = new Cliente();
        c.setNome("jorgin");
        c.setEmail("teste2@gmail.com");
        //Declarando persistence
        EntityManagerFactory entityManFac = Persistence.createEntityManagerFactory("default");
        //usando o persistence
        EntityManager entityManager = entityManFac.createEntityManager();
        // Iniciando a transação com o banco de dados
        entityManager.getTransaction().begin();

        // Persistindo (gravando) o objeto c no banco de dados
        //entityManager.persist(c);

        //Fazendo busca no BD
        //Cliente clibusca = entityManager.find(Cliente.class, 2);


        //System.out.println("Cliente encontrado: " + clibusca.getNome());

        // alterando dados do clibusca (cliente id 2)
        //clibusca.setNome("Jorgin 2.0");

        //excluindo o cliente id 2 clibusca
       // entityManager.remove(clibusca);

        // "comitando" (efetivando/enviando) a atualização no BD
        //entityManager.getTransaction().commit();

        //variável para utilizar na query
        String busca = "j";

        //Usando Query SQL
        Query q1 = entityManager.createQuery("SELECT e FROM Cliente e " +
                "WHERE e.nome " +
                "LIKE :ParametroNome");
        //trocando o parametro da query, pela variável busca
        q1.setParameter("ParametroNome",  busca + "%");

        //Armazenando resultado em arraylist do tipo entidade Cliente
        List<Cliente> listaResultado = q1.getResultList();

        //exibindo array, utilizando a quantidade de registro no objeto 'e'
        for (Cliente e:listaResultado){
            System.out.println("Nome: " + e.getNome() + "\nEmail: " + e.getEmail());
        }





        // Finalizando as comunicações com BD
        entityManager.close();
        entityManFac.close();


        //usando classe DAO
        ClienteDAO cDao = new ClienteDAO();
        Cliente cli = new Cliente();
        cli.setNome("Teste1909");
        cli.setEmail("email@teste");
        cDao.inseriCliente(cli);

    }
}
