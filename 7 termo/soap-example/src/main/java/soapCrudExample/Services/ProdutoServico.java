package soapCrudExample.Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import soapCrudExample.Models.Produto;
import soapCrudExample.Repository.ProdutoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ProdutoServico {
    private final ProdutoRepository repository;

    public ProdutoServico() {
        this.repository = new ProdutoRepository();
        inicializarDadosExemplo();
    }

    private void inicializarDadosExemplo() {
        if (repository.listarProdutos().isEmpty()) {
            criarProdutoExemplo("Produto 1", new BigDecimal("55.50"), 100, LocalDate.now().plusDays(7));
            criarProdutoExemplo("Produto 2", new BigDecimal("25.00"), 50, LocalDate.now().plusDays(3));
        }
    }

    private void criarProdutoExemplo(String nome, BigDecimal preco, Integer quantidade, LocalDate validade) {
        Produto produto = new Produto(null, nome, preco, quantidade, validade);
        repository.incluirProduto(produto);
    }

    @WebMethod(operationName = "incluirProduto")
    @WebResult(name = "produtoInserido")
    public Produto salvarProduto(
            @WebParam(name = "nome") String nome,
            @WebParam(name = "preco") BigDecimal preco,
            @WebParam(name = "quantidade") Integer quantidade,
            @WebParam(name = "validade") String validadeStr) {

        LocalDate validade = LocalDate.parse(validadeStr);
        Produto novoProduto = new Produto(null, nome, preco, quantidade, validade);
        repository.incluirProduto(novoProduto);
        return novoProduto;
    }

    @WebMethod(operationName = "listarProdutos")
    @WebResult(name = "produto")
    public List<Produto> listarProdutos() {
        return repository.listarProdutos();
    }

    @WebMethod(operationName = "buscarProdutoPorCodigo")
    @WebResult(name = "produto")
    public Produto buscarPorCodigo(@WebParam(name = "codigo") Long codigo) {
        return repository.buscarProdutoPorCodigo(codigo);
    }

    @WebMethod(operationName = "atualizarProduto")
    @WebResult(name = "produtoAtualizado")
    public Produto atualizarProduto(
            @WebParam(name = "codigo") Long codigo,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "preco") BigDecimal preco,
            @WebParam(name = "quantidade") Integer quantidade,
            @WebParam(name = "validade") String validadeStr) {

        Produto produtoExistente = repository.buscarProdutoPorCodigo(codigo);
        if (produtoExistente == null) {
            throw new RuntimeException("Produto não encontrado com código: " + codigo);
        }

        produtoExistente.setNome(nome);
        produtoExistente.setPreco(preco);
        produtoExistente.setQuantidade(quantidade);
        produtoExistente.setValidade(LocalDate.parse(validadeStr));

        return repository.editarProduto(produtoExistente);
    }

    @WebMethod(operationName = "removerProduto")
    @WebResult(name = "sucesso")
    public boolean removerProduto(@WebParam(name = "codigo") Long codigo) {
        return repository.excluirProdutoPorCodigo(codigo);
    }
}