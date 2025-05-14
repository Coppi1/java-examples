package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.MediaCalculoService;

@Path("/media")
public class MediaCalculoController {
    private MediaCalculoService service = new MediaCalculoService();

    @GET
    @Path("/aritmetica-dois/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public float mediaAritmeticaDoisNumeros(
            @PathParam("a") float a,
            @PathParam("b") float b) {
        return service.mediaAritmeticaDoisNumeros(a, b);
    }

    @GET
    @Path("/ponderada-dois/{a}/{b}/{pesoA}/{pesoB}")
    @Produces(MediaType.TEXT_PLAIN)
    public float mediaPonderadaDoisNumeros(
            @PathParam("a") float a,
            @PathParam("b") float b,
            @PathParam("pesoA") float pesoA,
            @PathParam("pesoB") float pesoB) {
        return service.mediaPonderadaDoisNumeros(a, b, pesoA, pesoB);
    }

    @GET
    @Path("/aritmetica-tres/{a}/{b}/{c}")
    @Produces(MediaType.TEXT_PLAIN)
    public float mediaAritmeticaTresNumeros(
            @PathParam("a") float a,
            @PathParam("b") float b,
            @PathParam("c") float c) {
        return service.mediaAritmeticaTresNumeros(a, b, c);
    }

    @GET
    @Path("/ponderada-tres/{a}/{b}/{c}/{pesoA}/{pesoB}/{pesoC}")
    @Produces(MediaType.TEXT_PLAIN)
    public float mediaPonderadaTresNumeros(
            @PathParam("a") float a,
            @PathParam("b") float b,
            @PathParam("c") float c,
            @PathParam("pesoA") float pesoA,
            @PathParam("pesoB") float pesoB,
            @PathParam("pesoC") float pesoC) {
        return service.mediaPonderadaTresNumeros(a, b, c, pesoA, pesoB, pesoC);
    }
}