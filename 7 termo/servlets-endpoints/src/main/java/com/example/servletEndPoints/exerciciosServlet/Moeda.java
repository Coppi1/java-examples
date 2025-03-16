package com.example.servletEndPoints.exerciciosServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/moeda/*")
public class Moeda extends HttpServlet {
    private final Map<String, Double> taxas = Map.of(
            "usd", 5.05,   // 1 USD = 5.05 BRL
            "eur", 5.45,   // 1 EUR = 5.45 BRL
            "pyg", 0.0007, // 1 PYG = 0.0007 BRL
            "ars", 0.005   // 1 ARS = 0.005 BRL
    );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        resp.setContentType("application/json");
        double valor = Double.parseDouble(req.getParameter("valor"));
        String tipo = req.getParameter("tipo");
        double resultado = 0;

        switch (tipo) {
            case "brl_usd" -> resultado = valor / taxas.get("usd");
            case "usd_brl" -> resultado = valor * taxas.get("usd");
            case "brl_eur" -> resultado = valor / taxas.get("eur");
            case "eur_brl" -> resultado = valor * taxas.get("eur");
            case "brl_pyg" -> resultado = valor / taxas.get("pyg");
            case "pyg_brl" -> resultado = valor * taxas.get("pyg");
            case "brl_ars" -> resultado = valor / taxas.get("ars");
            case "ars_brl" -> resultado = valor * taxas.get("ars");
        }

        String json = String.format("{\"resultado\": %.2f}", resultado);
        resp.getWriter().write(json);
    }
}