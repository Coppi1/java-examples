package com.example.servletEndPoints;

import com.example.servletEndPoints.exercicioBancoAuth.endPoint.Consultar;
import com.example.servletEndPoints.exercicioBancoAuth.endPoint.Depositar;
import com.example.servletEndPoints.exercicioBancoAuth.endPoint.Sacar;
import com.example.servletEndPoints.exercicioServidorProdutos.endPoint.ProdutoDelete;
import com.example.servletEndPoints.exercicioServidorProdutos.endPoint.ProdutoGet;
import com.example.servletEndPoints.exercicioServidorProdutos.endPoint.ProdutoPost;
import com.example.servletEndPoints.exercicioServidorProdutos.endPoint.ProdutoPut;
import com.example.servletEndPoints.exerciciosServlet.Comparacao;
import com.example.servletEndPoints.exerciciosServlet.Media;
import com.example.servletEndPoints.exerciciosServlet.Moeda;
import com.example.servletEndPoints.exerciciosServlet.Temperatura;
import com.example.servletEndPoints.security.SecurityConfig;
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
        contexto.addServlet(new ServletHolder(new ProdutoPost()), "/produto/post");
        contexto.addServlet(new ServletHolder(new ProdutoGet()), "/produto/get");
        contexto.addServlet(new ServletHolder(new ProdutoPut()), "/produto/put");
        contexto.addServlet(new ServletHolder(new ProdutoDelete()), "/produto/delete");

        ConstraintSecurityHandler security = SecurityConfig.configureSecurity(contexto);
        contexto.setSecurityHandler(security);

        servidor.setHandler(contexto);

        servidor.start();
        servidor.join();
    }
}
