package com.example.servletEndPoints.exercicioServidorProdutos.endPoint;

import com.example.servletEndPoints.exercicioServidorProdutos.DAO.ProdutoDAO;
import com.example.servletEndPoints.exercicioServidorProdutos.Model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProdutoGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        try {
            List<Produto> produtos = ProdutoDAO.getProdutos();
            StringBuilder response = new StringBuilder("Lista de produtos:\n");

            for (Produto produto : produtos) {
                response.append("Código: ").append(produto.getCodigo())
                        .append(", Nome: ").append(produto.getNome())
                        .append(", Preço: ").append(produto.getPreco())
                        .append(", Quantidade: ").append(produto.getQuantidade())
                        .append("\n");
            }

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(response.toString());
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Erro ao recuperar produtos: " + e.getMessage());
        }
    }
}