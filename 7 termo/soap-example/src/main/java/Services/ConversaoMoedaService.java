package Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class ConversaoMoedaService {

    private static final float TAXA_DOLAR = 5.0f;
    private static final float TAXA_EURO = 6.0f;
    private static final float TAXA_GUARANI = 0.001f;
    private static final float TAXA_PESO_ARGENTINO = 0.05f;

    @WebMethod
    public float realParaDolar(float real) {
        return real / TAXA_DOLAR;
    }

    @WebMethod
    public float dolarParaReal(float dolar) {
        return dolar * TAXA_DOLAR;
    }

    @WebMethod
    public float realParaEuro(float real) {
        return real / TAXA_EURO;
    }

    @WebMethod
    public float euroParaReal(float euro) {
        return euro * TAXA_EURO;
    }

    @WebMethod
    public float realParaGuarani(float real) {
        return real / TAXA_GUARANI;
    }

    @WebMethod
    public float guaraniParaReal(float guarani) {
        return guarani * TAXA_GUARANI;
    }

    @WebMethod
    public float realParaPesoArgentino(float real) {
        return real / TAXA_PESO_ARGENTINO;
    }

    @WebMethod
    public float pesoArgentinoParaReal(float pesoArgentino) {
        return pesoArgentino * TAXA_PESO_ARGENTINO;
    }
}