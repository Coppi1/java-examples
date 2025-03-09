package com.example.servletsendpoints;

import com.example.servletsendpoints.exercicioBancoAuth.EndPoint.Consultar;
import com.example.servletsendpoints.exercicioBancoAuth.EndPoint.Depositar;
import com.example.servletsendpoints.exercicioBancoAuth.EndPoint.Sacar;
import com.example.servletsendpoints.exerciciosServlet.Comparacao;
import com.example.servletsendpoints.exerciciosServlet.Media;
import com.example.servletsendpoints.exerciciosServlet.Moeda;
import com.example.servletsendpoints.exerciciosServlet.Temperatura;
import com.example.servletsendpoints.security.SecurityConfig;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application {

    public static void main(String[] args) throws Exception {
        Server servidor = new Server(8080);

        ServletContextHandler contexto = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contexto.setContextPath("/api");
        contexto.addServlet(new ServletHolder(new Temperatura()), "/temperatura/*");
        contexto.addServlet(new ServletHolder(new Moeda()), "/moeda/*");
        contexto.addServlet(new ServletHolder(new Media()), "/media/*");
        contexto.addServlet(new ServletHolder(new Comparacao()), "/comparacao/*");
        contexto.addServlet(new ServletHolder(new Sacar()), "/sacar");
        contexto.addServlet(new ServletHolder(new Depositar()), "/depositar");
        contexto.addServlet(new ServletHolder(new Consultar()), "/consultar");

        ConstraintSecurityHandler security = SecurityConfig.configureSecurity(contexto);
        contexto.setSecurityHandler(security);

        servidor.setHandler(contexto);

        servidor.start();
        servidor.join();
    }
}
