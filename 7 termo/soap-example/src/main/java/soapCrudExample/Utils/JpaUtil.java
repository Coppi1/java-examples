package soapCrudExample.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        Map<String, String> props = new HashMap<>();
        try (InputStream input = JpaUtil.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties properties = new Properties();
            properties.load(input);

            props.put("jakarta.persistence.jdbc.user",
                    properties.getProperty("DB_USER"));
            props.put("jakarta.persistence.jdbc.password",
                    properties.getProperty("DB_PASS"));

        } catch (IOException e) {
            // Tratar erro de leitura do arquivo
        }

        emf = Persistence.createEntityManagerFactory("appPU", props);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}