package com.example.servletEndPoints.exercicioBancoAuth.endPoint;

import com.example.servletEndPoints.exercicioBancoAuth.DAO.BancoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Depositar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String conta = req.getUserPrincipal().getName();
        try {
            double valor = Double.parseDouble(req.getParameter("valor"));
            if (valor <= 0) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Valor deve ser positivo.");
                return;
            }
            BancoDAO.depositar(conta, valor);
            resp.getWriter().write("Depósito realizado com sucesso.");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Valor inválido.");
        }
    }
}