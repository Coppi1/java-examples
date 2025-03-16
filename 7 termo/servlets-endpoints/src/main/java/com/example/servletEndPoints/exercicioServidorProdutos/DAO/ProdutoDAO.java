package com.example.servletEndPoints.exercicioServidorProdutos.DAO;


import com.example.servletEndPoints.exercicioServidorProdutos.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static final List<Produto> produtos = new ArrayList<>();

    static {
        produtos.add(new Produto(1, "Produto 1", 10.0, 100));
        produtos.add(new Produto(2, "Produto 2", 20.0, 200));
        produtos.add(new Produto(3, "Produto 3", 30.0, 300));
        produtos.add(new Produto(4, "Produto 4", 40.0, 400));
        produtos.add(new Produto(5, "Produto 5", 50.0, 500));
    }

    public static synchronized List<Produto> getProdutos() {
        return produtos;
    }

    public static synchronized void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static synchronized void atualizarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(produto.getCodigo())) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                p.setQuantidade(produto.getQuantidade());
                break;
            }
        }
    }

    public static synchronized void removerProduto(Integer codigo) {
        produtos.removeIf(p -> p.getCodigo().equals(codigo));
    }
}