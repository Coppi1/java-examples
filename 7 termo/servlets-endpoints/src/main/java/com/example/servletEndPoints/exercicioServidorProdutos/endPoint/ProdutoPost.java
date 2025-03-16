package com.example.servletEndPoints.exercicioServidorProdutos.endPoint;


import com.example.servletEndPoints.exercicioServidorProdutos.DAO.ProdutoDAO;
import com.example.servletEndPoints.exercicioServidorProdutos.Model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProdutoPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            String nome = req.getParameter("nome");
            double preco = Double.parseDouble(req.getParameter("preco"));
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));

            Produto produto = new Produto(codigo,nome, preco, quantidade);

            ProdutoDAO.adicionarProduto(produto);

            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("Produto incluído com sucesso.");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Dados inválidos. Verifique os valores informados.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Erro ao processar a requisição: " + e.getMessage());
        }
    }
}