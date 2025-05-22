package service;

import models.Produto;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    private final ProdutoRepository repository = new ProdutoRepository();

    public void incluirProduto(Produto produto) {
        repository.incluirProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return repository.listarProdutos();
    }

    public Optional<Produto> buscarPorCodigo(Long codigo) {
        return Optional.ofNullable(repository.buscarProdutoPorCodigo(codigo));
    }

    public void excluirProduto(Long codigo) {
        repository.excluirProdutoPorCodigo(codigo);
    }

    public void atualizarProduto(Produto produto) {
        repository.editarProduto(produto);
    }
}