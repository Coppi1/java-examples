package service;

public class ConversaoMoedaService {

    private static final float TAXA_DOLAR = 5.0f;
    private static final float TAXA_EURO = 5.5f;
    private static final float TAXA_GUARANI = 0.0007f;
    private static final float TAXA_PESO_ARGENTINO = 0.05f;

    public float realParaDolar(float real) {
        return real / TAXA_DOLAR;
    }

    public float dolarParaReal(float dolar) {
        return dolar * TAXA_DOLAR;
    }

    public float realParaEuro(float real) {
        return real / TAXA_EURO;
    }

    public float euroParaReal(float euro) {
        return euro * TAXA_EURO;
    }

    public float realParaGuarani(float real) {
        return real / TAXA_GUARANI;
    }

    public float guaraniParaReal(float guarani) {
        return guarani * TAXA_GUARANI;
    }

    public float realParaPesoArgentino(float real) {
        return real / TAXA_PESO_ARGENTINO;
    }

    public float pesoArgentinoParaReal(float peso) {
        return peso * TAXA_PESO_ARGENTINO;
    }
}