package services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CalculadoraService {

    @WebMethod
    public double somar(double a, double b)  {
        return a + b;
    }

    @WebMethod
    public double subratir(double a, double b)  {
        return a - b;
    }
}
