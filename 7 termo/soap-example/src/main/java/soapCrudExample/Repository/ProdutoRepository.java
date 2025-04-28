package soapCrudExample.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import soapCrudExample.Models.Produto;
import soapCrudExample.Utils.JpaUtil;

import java.util.List;


public class ProdutoRepository {

    private EntityTransaction tx;

    public void incluirProduto(Produto produto) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(produto);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Produto> listarProdutos() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Produto p ORDER BY p.codigo", Produto.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public Produto buscarProdutoPorCodigo(Long codigo) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Produto.class, codigo);
        } finally {
            em.close();
        }
    }

    public boolean excluirProdutoPorCodigo(Long codigo) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Produto produto = em.find(Produto.class, codigo);
            if (produto != null) {
                em.remove(produto);
                tx.commit();
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Produto editarProduto(Produto produto) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            Produto produtoAtualizado = em.merge(produto);
            tx.commit();
            return produtoAtualizado;
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}