package com.example.servletEndPoints.exerciciosServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/comparacao/*")
public class Comparacao extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String operacao = req.getPathInfo().substring(1);
        int maior = Integer.MIN_VALUE;

        switch (operacao) {
            case "maior2" -> {
                int n1 = Integer.parseInt(req.getParameter("n1"));
                int n2 = Integer.parseInt(req.getParameter("n2"));
                maior = Math.max(n1, n2);
            }
            case "maior3" -> {
                int n1 = Integer.parseInt(req.getParameter("n1"));
                int n2 = Integer.parseInt(req.getParameter("n2"));
                int n3 = Integer.parseInt(req.getParameter("n3"));
                maior = Math.max(n1, Math.max(n2, n3));
            }
        }

        String json = String.format("{\"maior\": %d}", maior);
        resp.getWriter().write(json);
    }
}