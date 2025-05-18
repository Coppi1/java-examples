package controllers;

import entidades.Produto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/produtos")
public class ProdutoController {
    private static List<Produto> produtos = new ArrayList<>();

    // dados de exemplo
    static {
        produtos.add(new Produto(1L, "Leite", BigDecimal.valueOf(5.99), 50, LocalDate.of(2024, 12, 31)));
        produtos.add(new Produto(2L, "Pão", BigDecimal.valueOf(9.90), 30, LocalDate.of(2024, 6, 15)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(produtos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluir(Produto novoProduto) {
        produtos.add(novoProduto);
        return Response.status(Response.Status.CREATED).entity(novoProduto).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorCodigo(@PathParam("codigo") Long codigo) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();

        return produto.map(p -> Response.ok(p).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirPorCodigo(@PathParam("codigo") Long codigo) {
        boolean removido = produtos.removeIf(p -> p.getCodigo().equals(codigo));

        return removido
                ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("codigo") Long codigo, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();

        if (produtoExistente.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Produto produto = produtoExistente.get();
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setValidade(produtoAtualizado.getValidade());

        return Response.ok(produto).build();
    }
}