package soapCrudExample.Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import soapCrudExample.Models.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ProdutoServico {
    private List<Produto> produtos;
    private Long ultimoCodigo = 0L;

    public ProdutoServico() {
        produtos = new ArrayList<>();

        adicionarProdutoExemplo("Produto1", new BigDecimal("55.50"), 100, LocalDate.now().plusDays(7));
        adicionarProdutoExemplo("Produto2", new BigDecimal("25.00"), 50, LocalDate.now().plusDays(3));
    }

    private void adicionarProdutoExemplo(String nome, BigDecimal preco, Integer quantidade, LocalDate validade) {
        ultimoCodigo++;
        produtos.add(new Produto(ultimoCodigo, nome, preco, quantidade, validade));
    }

    @WebMethod(operationName = "incluirProduto")
    @WebResult(name = "produtoInserido")
    public Produto salvarProduto(@WebParam(name = "nome") String nome, @WebParam(name = "preco") BigDecimal preco, @WebParam(name = "quantidade") Integer quantidade, @WebParam(name = "validade") String validadeStr) {
        LocalDate validade = LocalDate.parse(validadeStr);

        ultimoCodigo++;
        Produto novoProduto = new Produto(ultimoCodigo, nome, preco, quantidade, validade);
        produtos.add(novoProduto);
        return novoProduto;
    }

    @WebMethod(operationName = "listarProdutos")
    @WebResult(name = "produto")
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @WebMethod(operationName = "buscarProdutoPorCodigo")
    @WebResult(name = "produto")
    public Produto buscarPorCodigo(@WebParam(name = "codigo") Long codigo) {
        return produtos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
}