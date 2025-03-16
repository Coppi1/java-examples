package com.example.servletEndPoints.exercicioBancoAuth.endPoint;

import com.example.servletEndPoints.exercicioBancoAuth.DAO.BancoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Sacar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String conta = req.getUserPrincipal().getName();
        try {
            double valor = Double.parseDouble(req.getParameter("valor"));
            boolean sucesso = BancoDAO.sacar(conta, valor);
            if (sucesso) {
                resp.getWriter().write("Saque realizado com sucesso.");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Saldo insuficiente.");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Valor inválido.");
        }
    }
}