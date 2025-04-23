import soapCrudExample.Services.ProdutoServico;
import soapHelloWorld.Services.CalculoMediaService;
import soapHelloWorld.Services.ComparacaoNumeroService;
import soapHelloWorld.Services.ConversaoMoedaService;
import soapHelloWorld.Services.TemperaturaService;
import jakarta.xml.ws.Endpoint;

public class Application {

    public static void main(String[] args) {
//        Endpoint.publish("http://localhost:8080/conversao-temperatura", new TemperaturaService());
//        Endpoint.publish("http://localhost:8080/conversao-moeda", new ConversaoMoedaService());
//        Endpoint.publish("http://localhost:8080/calculo-media", new CalculoMediaService());
//        Endpoint.publish("http://localhost:8080/comparacao-numeros", new ComparacaoNumeroService());

        Endpoint.publish("http://localhost:8080/produto", new ProdutoServico());
    }
}
