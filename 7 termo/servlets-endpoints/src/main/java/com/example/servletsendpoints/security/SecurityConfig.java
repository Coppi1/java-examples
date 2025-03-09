package com.example.servletsendpoints.security;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.UserStore;
import org.eclipse.jetty.util.security.Credential;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.Arrays;

public class SecurityConfig {

    public static ConstraintSecurityHandler configureSecurity(ServletContextHandler context) {
        Constraint restricao = new Constraint();
        restricao.setName(Constraint.__BASIC_AUTH);
        restricao.setAuthenticate(true);
        restricao.setRoles(new String[]{"administrador", "usuario"});

        ConstraintMapping sacarMapping = new ConstraintMapping();
        sacarMapping.setConstraint(restricao);
        sacarMapping.setPathSpec("/sacar");

        ConstraintMapping depositarMapping = new ConstraintMapping();
        depositarMapping.setConstraint(restricao);
        depositarMapping.setPathSpec("/depositar");

        ConstraintMapping consultarMapping = new ConstraintMapping();
        consultarMapping.setConstraint(restricao);
        consultarMapping.setPathSpec("/consultar");

        UserStore usuarios = new UserStore();
        usuarios.addUser("1001", Credential.getCredential("senha123"), new String[]{"usuario"});
        usuarios.addUser("2002", Credential.getCredential("senha123"), new String[]{"usuario"});
        usuarios.addUser("3003", Credential.getCredential("senha123"), new String[]{"usuario"});

        HashLoginService autenticacao = new HashLoginService();
        autenticacao.setUserStore(usuarios);

        ConstraintSecurityHandler seguranca = new ConstraintSecurityHandler();
        Arrays.asList(sacarMapping, depositarMapping, consultarMapping)
                .forEach(seguranca::addConstraintMapping);
        seguranca.setLoginService(autenticacao);
        seguranca.setAuthenticator(new BasicAuthenticator());

        return seguranca;
    }
}