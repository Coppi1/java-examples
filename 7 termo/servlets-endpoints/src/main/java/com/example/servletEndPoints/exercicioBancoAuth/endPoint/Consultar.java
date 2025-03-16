package com.example.servletEndPoints.exercicioBancoAuth.endPoint;

import com.example.servletEndPoints.exercicioBancoAuth.DAO.BancoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Consultar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String conta = req.getUserPrincipal().getName();
        double saldo = BancoDAO.getSaldo(conta);
        resp.getWriter().write(String.format("Saldo atual: R$ %.2f", saldo));
    }
}