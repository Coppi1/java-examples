package Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CalculoMediaService {

    @WebMethod
    public float mediaAritmeticaDoisNumeros(float num1, float num2) {
        return (num1 + num2) / 2;
    }

    @WebMethod
    public float mediaPonderadaDoisNumeros(float num1, float num2, float peso1, float peso2) {
        return (num1 * peso1 + num2 * peso2) / (peso1 + peso2);
    }

    @WebMethod
    public float mediaAritmeticaTresNumeros(float num1, float num2, float num3) {
        return (num1 + num2 + num3) / 3;
    }

    @WebMethod
    public float mediaPonderadaTresNumeros(float num1, float num2, float num3, float peso1, float peso2, float peso3) {
        return (num1 * peso1 + num2 * peso2 + num3 * peso3) / (peso1 + peso2 + peso3);
    }
}