import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import controller.ConversaoMoedaController;
import controller.ConversaoTemperaturaController;
import controller.MediaCalculoController;

public class App {
    public static void main(String[] args) {
        JAXRSServerFactoryBean servidor = new JAXRSServerFactoryBean();

        servidor.setResourceClasses(
                ConversaoTemperaturaController.class,
                ConversaoMoedaController.class,
                MediaCalculoController.class
        );

        servidor.setAddress("http://localhost:8080/api");
        servidor.create();

        System.out.println("Servidor: http://localhost:8080/api");
    }
}