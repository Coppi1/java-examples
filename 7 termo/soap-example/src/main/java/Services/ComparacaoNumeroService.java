package Services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class ComparacaoNumeroService {

    @WebMethod
    public int maiorEntreDoisNumeros(int num1, int num2) {
        return Math.max(num1, num2);
    }

    @WebMethod
    public int maiorEntreTresNumeros(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
}