package controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.Produto;
import service.ProdutoService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        List<Produto> produtos = produtoService.listarProdutos();
        return Response.ok(produtos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluir(Produto novoProduto) {
        produtoService.incluirProduto(novoProduto);
        return Response.status(Response.Status.CREATED).entity(novoProduto).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorCodigo(@PathParam("codigo") Long codigo) {
        Optional<Produto> produto = produtoService.buscarPorCodigo(codigo);
        return produto.map(p -> Response.ok(p).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirPorCodigo(@PathParam("codigo") Long codigo) {
        Optional<Produto> produtoExistente = produtoService.buscarPorCodigo(codigo);
        if (produtoExistente.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        produtoService.excluirProduto(codigo);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("codigo") Long codigo, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoService.buscarPorCodigo(codigo);
        if (produtoExistente.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Produto produto = produtoExistente.get();
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setValidade(produtoAtualizado.getValidade());

        produtoService.atualizarProduto(produto);
        return Response.ok(produto).build();
    }
}