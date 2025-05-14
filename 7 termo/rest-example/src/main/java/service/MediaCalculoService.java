package service;

public class MediaCalculoService {
    public float mediaAritmeticaDoisNumeros(float a, float b) {
        return (a + b) / 2;
    }

    public float mediaPonderadaDoisNumeros(float a, float b, float pesoA, float pesoB) {
        return (a * pesoA + b * pesoB) / (pesoA + pesoB);
    }

    public float mediaAritmeticaTresNumeros(float a, float b, float c) {
        return (a + b + c) / 3;
    }

    public float mediaPonderadaTresNumeros(float a, float b, float c, float pesoA, float pesoB, float pesoC) {
        return (a * pesoA + b * pesoB + c * pesoC) / (pesoA + pesoB + pesoC);
    }
}