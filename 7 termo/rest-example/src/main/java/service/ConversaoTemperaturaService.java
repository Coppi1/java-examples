package service;

public class ConversaoTemperaturaService {
    public float celsiusParaFahrenheit(float celsius) {
        return (celsius * 9/5) + 32;
    }

    public float celsiusParaKelvin(float celsius) {
        return celsius + 273.15f;
    }

    public float fahrenheitParaCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public float kelvinParaCelsius(float kelvin) {
        return kelvin - 273.15f;
    }
}