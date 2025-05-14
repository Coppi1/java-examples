package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.ConversaoTemperaturaService;

@Path("/temperatura")
public class ConversaoTemperaturaController {
    private ConversaoTemperaturaService service = new ConversaoTemperaturaService();

    @GET
    @Path("/celsius-para-fahrenheit/{celsius}")
    @Produces(MediaType.TEXT_PLAIN)
    public float celsiusParaFahrenheit(@PathParam("celsius") float celsius) {
        return service.celsiusParaFahrenheit(celsius);
    }

    @GET
    @Path("/celsius-para-kelvin/{celsius}")
    @Produces(MediaType.TEXT_PLAIN)
    public float celsiusParaKelvin(@PathParam("celsius") float celsius) {
        return service.celsiusParaKelvin(celsius);
    }

    @GET
    @Path("/fahrenheit-para-celsius/{fahrenheit}")
    @Produces(MediaType.TEXT_PLAIN)
    public float fahrenheitParaCelsius(@PathParam("fahrenheit") float fahrenheit) {
        return service.fahrenheitParaCelsius(fahrenheit);
    }

    @GET
    @Path("/kelvin-para-celsius/{kelvin}")
    @Produces(MediaType.TEXT_PLAIN)
    public float kelvinParaCelsius(@PathParam("kelvin") float kelvin) {
        return service.kelvinParaCelsius(kelvin);
    }
}