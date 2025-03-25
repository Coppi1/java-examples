import jakarta.xml.ws.Endpoint;
import services.CalculadoraService;

public class Application {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/calculadora", new CalculadoraService());
    }
}
