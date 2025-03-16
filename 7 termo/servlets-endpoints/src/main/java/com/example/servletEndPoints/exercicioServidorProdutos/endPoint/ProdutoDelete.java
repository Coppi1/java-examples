package com.example.servletEndPoints.exercicioServidorProdutos.endPoint;

import com.example.servletEndPoints.exercicioServidorProdutos.DAO.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProdutoDelete extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            ProdutoDAO.removerProduto(codigo);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Produto removido com sucesso.");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Código inválido. Verifique o valor informado.");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Erro ao remover o produto: " + e.getMessage());
        }
    }
}