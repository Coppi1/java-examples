package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.ConversaoMoedaService;

@Path("/moeda")
public class ConversaoMoedaController {
    private ConversaoMoedaService service = new ConversaoMoedaService();

    @GET
    @Path("/real-para-dolar/{real}")
    @Produces(MediaType.TEXT_PLAIN)
    public float realParaDolar(@PathParam("real") float real) {
        return service.realParaDolar(real);
    }

    @GET
    @Path("/dolar-para-real/{dolar}")
    @Produces(MediaType.TEXT_PLAIN)
    public float dolarParaReal(@PathParam("dolar") float dolar) {
        return service.dolarParaReal(dolar);
    }

    @GET
    @Path("/real-para-euro/{real}")
    @Produces(MediaType.TEXT_PLAIN)
    public float realParaEuro(@PathParam("real") float real) {
        return service.realParaEuro(real);
    }

    @GET
    @Path("/euro-para-real/{euro}")
    @Produces(MediaType.TEXT_PLAIN)
    public float euroParaReal(@PathParam("euro") float euro) {
        return service.euroParaReal(euro);
    }

    @GET
    @Path("/real-para-guarani/{real}")
    @Produces(MediaType.TEXT_PLAIN)
    public float realParaGuarani(@PathParam("real") float real) {
        return service.realParaGuarani(real);
    }

    @GET
    @Path("/guarani-para-real/{guarani}")
    @Produces(MediaType.TEXT_PLAIN)
    public float guaraniParaReal(@PathParam("guarani") float guarani) {
        return service.guaraniParaReal(guarani);
    }

    @GET
    @Path("/real-para-peso-argentino/{real}")
    @Produces(MediaType.TEXT_PLAIN)
    public float realParaPesoArgentino(@PathParam("real") float real) {
        return service.realParaPesoArgentino(real);
    }

    @GET
    @Path("/peso-argentino-para-real/{peso}")
    @Produces(MediaType.TEXT_PLAIN)
    public float pesoArgentinoParaReal(@PathParam("peso") float peso) {
        return service.pesoArgentinoParaReal(peso);
    }
}