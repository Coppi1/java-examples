import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logger logger = Logger.getLogger(Servidor.class.getName());

        logger.info("Iniciando o servidor!");
        ServerSocket servidor = new ServerSocket(40000);
        logger.info("Servidor iniciado com sucesso!");

        while (true) {
            logger.info("Aceitando conexões!");
            Socket conexao = servidor.accept();
            logger.info("Conexão aceita com sucesso!");

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            logger.info("Recebendo uma requisição!");
            String requisicao = (String) entrada.readObject();
            logger.info("Requisição recebida com sucesso: " + requisicao + "!");

            String[] parametros = requisicao.split(";");
            String resposta = "";

            switch (parametros[0]) {
                case "temperatura": // Conversão de Temperatura
                    int tipoTemp = Integer.parseInt(parametros[1]);
                    double temp = Double.parseDouble(parametros[2]);
                    double resultadoTemp = 0;

                    switch (tipoTemp) {
                        case 0: // Celsius → Fahrenheit
                            resultadoTemp = (temp * 9 / 5) + 32;
                            break;
                        case 1: // Celsius → Kelvin
                            resultadoTemp = temp + 273.15;
                            break;
                        case 2: // Fahrenheit → Celsius
                            resultadoTemp = (temp - 32) * 5 / 9;
                            break;
                        case 3: // Kelvin → Celsius
                            resultadoTemp = temp - 273.15;
                            break;
                    }
                    resposta = "200;" + resultadoTemp;
                    break;

                case "moeda": // Conversão de Moedas
                    int tipoMoeda = Integer.parseInt(parametros[1]);
                    double valor = Double.parseDouble(parametros[2]);

                    double resultadoMoeda = 0;
                    double taxaDolar = 5.0;
                    double taxaEuro = 6.0;
                    double taxaGuarani = 0.001;
                    double taxaPesoArgentino = 0.05;

                    switch (tipoMoeda) {
                        case 0: // Real → Dólar
                            resultadoMoeda = valor / taxaDolar;
                            break;
                        case 1: // Dólar → Real
                            resultadoMoeda = valor * taxaDolar;
                            break;
                        case 2: // Real → Euro
                            resultadoMoeda = valor / taxaEuro;
                            break;
                        case 3: // Euro → Real
                            resultadoMoeda = valor * taxaEuro;
                            break;
                        case 4: // Real → Guarani
                            resultadoMoeda = valor / taxaGuarani;
                            break;
                        case 5: // Guarani → Real
                            resultadoMoeda = valor * taxaGuarani;
                            break;
                        case 6: // Real → Peso Argentino
                            resultadoMoeda = valor / taxaPesoArgentino;
                            break;
                        case 7: // Peso Argentino → Real
                            resultadoMoeda = valor * taxaPesoArgentino;
                            break;
                    }
                    resposta = "200;" + resultadoMoeda;
                    break;

                case "media": // Cálculo de Médias
                    int tipoMedia = Integer.parseInt(parametros[1]);
                    double resultadoMedia = 0;

                    switch (tipoMedia) {
                        case 0: // Média Aritmética entre Dois Números
                            double num1 = Double.parseDouble(parametros[2]);
                            double num2 = Double.parseDouble(parametros[3]);
                            resultadoMedia = (num1 + num2) / 2;
                            break;
                        case 1: // Média Ponderada entre Dois Números
                            num1 = Double.parseDouble(parametros[2]);
                            num2 = Double.parseDouble(parametros[3]);
                            double peso1 = Double.parseDouble(parametros[4]);
                            double peso2 = Double.parseDouble(parametros[5]);
                            resultadoMedia = (num1 * peso1 + num2 * peso2) / (peso1 + peso2);
                            break;
                        case 2: // Média Aritmética entre Três Números
                            num1 = Double.parseDouble(parametros[2]);
                            num2 = Double.parseDouble(parametros[3]);
                            double num3 = Double.parseDouble(parametros[4]);
                            resultadoMedia = (num1 + num2 + num3) / 3;
                            break;
                        case 3: // Média Ponderada entre Três Números
                            num1 = Double.parseDouble(parametros[2]);
                            num2 = Double.parseDouble(parametros[3]);
                            num3 = Double.parseDouble(parametros[4]);
                            peso1 = Double.parseDouble(parametros[5]);
                            peso2 = Double.parseDouble(parametros[6]);
                            double peso3 = Double.parseDouble(parametros[7]);
                            resultadoMedia = (num1 * peso1 + num2 * peso2 + num3 * peso3) / (peso1 + peso2 + peso3);
                            break;
                    }
                    resposta = "200;" + resultadoMedia;
                    break;

                case "comparacao": // Comparação de Números
                    int tipoComparacao = Integer.parseInt(parametros[1]);
                    double resultadoComparacao = 0;

                    if (tipoComparacao == 0) { // Maior entre Dois Números
                        int num1 = Integer.parseInt(parametros[2]);
                        int num2 = Integer.parseInt(parametros[3]);
                        resultadoComparacao = Math.max(num1, num2);
                    } else { // Maior entre Três Números
                        int num1 = Integer.parseInt(parametros[2]);
                        int num2 = Integer.parseInt(parametros[3]);
                        int num3 = Integer.parseInt(parametros[4]);
                        resultadoComparacao = Math.max(Math.max(num1, num2), num3);
                    }
                    resposta = "200;" + resultadoComparacao;
                    break;

                default:
                    resposta = "500;Operação inválida";
            }

            logger.info("Enviando uma resposta: " + resposta + "!");
            saida.writeObject(resposta);
            logger.info("Resposta enviada com sucesso!");

            logger.info("Finalizando a conexão!");
            conexao.close();
            logger.info("Conexão finalizada com sucesso!");
        }
    }
}