package Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class TemperaturaService {

    @WebMethod
    public float celsiusParaFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    @WebMethod
    public float celsiusParaKelvin(float celsius) {
        return celsius + 273.15f;
    }

    @WebMethod
    public float fahrenheitParaCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    @WebMethod
    public float kelvinParaCelsius(float kelvin) {
        return kelvin - 273.15f;
    }
}
