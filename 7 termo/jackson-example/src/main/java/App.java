import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import controllers.ProdutoController;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {
        JAXRSServerFactoryBean servidor = new JAXRSServerFactoryBean();

        // Configurar o Jackson para lidar com LocalDate
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        JacksonJsonProvider provider = new JacksonJsonProvider();

        provider.setMapper(mapper);

        servidor.setResourceClasses(
                ProdutoController.class
        );

        servidor.setAddress("http://localhost:8080/api");
        servidor.setProvider(provider);
        servidor.create();
    }
}