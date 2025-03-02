package com.example.servletsendpoints;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/media/*")
public class Media extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String operacao = req.getPathInfo().substring(1);
        double resultado = 0;

        switch (operacao) {
            case "aritmetica2" -> {
                double n1 = Double.parseDouble(req.getParameter("n1"));
                double n2 = Double.parseDouble(req.getParameter("n2"));
                resultado = (n1 + n2) / 2;
            }
            case "ponderada2" -> {
                double n1 = Double.parseDouble(req.getParameter("n1"));
                double p1 = Double.parseDouble(req.getParameter("p1"));
                double n2 = Double.parseDouble(req.getParameter("n2"));
                double p2 = Double.parseDouble(req.getParameter("p2"));
                resultado = (n1 * p1 + n2 * p2) / (p1 + p2);
            }
            case "aritmetica3" -> {
                double n1 = Double.parseDouble(req.getParameter("n1"));
                double n2 = Double.parseDouble(req.getParameter("n2"));
                double n3 = Double.parseDouble(req.getParameter("n3"));
                resultado = (n1 + n2 + n3) / 3;
            }
            case "ponderada3" -> {
                double n1 = Double.parseDouble(req.getParameter("n1"));
                double p1 = Double.parseDouble(req.getParameter("p1"));
                double n2 = Double.parseDouble(req.getParameter("n2"));
                double p2 = Double.parseDouble(req.getParameter("p2"));
                double n3 = Double.parseDouble(req.getParameter("n3"));
                double p3 = Double.parseDouble(req.getParameter("p3"));
                resultado = (n1 * p1 + n2 * p2 + n3 * p3) / (p1 + p2 + p3);
            }
        }

        String json = String.format("{\"resultado\": %.2f}", resultado);
        resp.getWriter().write(json);
    }
}