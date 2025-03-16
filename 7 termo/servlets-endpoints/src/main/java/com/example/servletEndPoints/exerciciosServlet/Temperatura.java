package com.example.servletEndPoints.exerciciosServlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/temperatura/*")
public class Temperatura extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        double valor = Double.parseDouble(req.getParameter("valor"));
        String tipo = req.getParameter("tipo");
        double resultado = 0;

        switch (tipo) {
            case "cf" -> resultado = (valor * 9 / 5) + 32;
            case "ck" -> resultado = valor + 273.15;
            case "fc" -> resultado = (valor - 32) * 5 / 9;
            case "kc" -> resultado = valor - 273.15;
        }

        String json = String.format("{\"resultado\": %.2f}", resultado);
        resp.getWriter().write(json);
    }
}

