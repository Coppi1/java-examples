package com.example.servletsendpoints;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class Application {

    public static void main(String[] args) throws Exception {
        Server servidor = new Server(8080);

        ServletContextHandler contexto = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contexto.setContextPath("/api");
        contexto.addServlet(new ServletHolder(new Temperatura()), "/temperatura/*");
        contexto.addServlet(new ServletHolder(new Moeda()), "/moeda/*");
        contexto.addServlet(new ServletHolder(new Media()), "/media/*");
        contexto.addServlet(new ServletHolder(new Comparacao()), "/comparacao/*");
        servidor.setHandler(contexto);

        servidor.start();
        servidor.join();
    }
}
