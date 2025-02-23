package PrimeiroTrab;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientePrimeiro {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String[] opcoes = {
                "Conversão de Temperatura",
                "Conversão de Moedas",
                "Cálculo de Médias",
                "Comparação de Números"
        };

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha um serviço:",
                "Serviços Disponíveis",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        String requisicao = "";

        switch (escolha) {
            case 0: // Conversão de Temperatura
                String[] temperaturas = {
                        "Celsius → Fahrenheit", "Celsius → Kelvin",
                        "Fahrenheit → Celsius",
                        "Kelvin → Celsius"
                };
                int tempEscolha = JOptionPane.showOptionDialog(
                        null,
                        "Escolha a conversão de temperatura:",
                        "Conversão de Temperatura",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        temperaturas,
                        temperaturas[0]
                );
                double temp = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura:"));
                requisicao = "temperatura;" + tempEscolha + ";" + temp;
                break;

            case 1: // Conversão de Moedas
                String[] moedas = {
                        "Real → Dólar",
                        "Dólar → Real",
                        "Real → Euro",
                        "Euro → Real",
                        "Real → Guarani",
                        "Guarani → Real",
                        "Real → Peso Argentino",
                        "Peso Argentino → Real"
                };
                int moedaEscolha = JOptionPane.showOptionDialog(
                        null,
                        "Escolha a conversão de moeda:",
                        "Conversão de Moedas",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        moedas,
                        moedas[0]
                );
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor:"));
                requisicao = "moeda;" + moedaEscolha + ";" + valor;
                break;

            case 2: // Cálculo de Médias
                String[] medias = {
                        "Média Aritmética entre Dois Números",
                        "Média Ponderada entre Dois Números",
                        "Média Aritmética entre Três Números",
                        "Média Ponderada entre Três Números"
                };
                int mediaEscolha = JOptionPane.showOptionDialog(
                        null,
                        "Escolha o tipo de média:",
                        "Cálculo de Médias",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        medias,
                        medias[0]
                );
                if (mediaEscolha == 0 || mediaEscolha == 1) {
                    double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                    double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
                    if (mediaEscolha == 1) {
                        double peso1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do primeiro número:"));
                        double peso2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do segundo número:"));
                        requisicao = "media;" + mediaEscolha + ";" + num1 + ";" + num2 + ";" + peso1 + ";" + peso2;
                    } else {
                        requisicao = "media;" + mediaEscolha + ";" + num1 + ";" + num2;
                    }
                } else {
                    double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                    double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
                    double num3 = Double.parseDouble(JOptionPane.showInputDialog("Digite o terceiro número:"));
                    if (mediaEscolha == 3) {
                        double peso1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do primeiro número:"));
                        double peso2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do segundo número:"));
                        double peso3 = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do terceiro número:"));
                        requisicao = "media;" + mediaEscolha + ";" + num1 + ";" + num2 + ";" + num3 + ";" + peso1 + ";" + peso2 + ";" + peso3;
                    } else {
                        requisicao = "media;" + mediaEscolha + ";" + num1 + ";" + num2 + ";" + num3;
                    }
                }
                break;

            case 3: // Comparação de Números
                String[] comparacoes = {
                        "Maior entre Dois Números",
                        "Maior entre Três Números"
                };
                int compEscolha = JOptionPane.showOptionDialog(
                        null,
                        "Escolha o tipo de comparação:",
                        "Comparação de Números",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        comparacoes,
                        comparacoes[0]
                );
                if (compEscolha == 0) {
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
                    requisicao = "comparacao;" + compEscolha + ";" + num1 + ";" + num2;
                } else {
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
                    int num3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número:"));
                    requisicao = "comparacao;" + compEscolha + ";" + num1 + ";" + num2 + ";" + num3;
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                System.exit(0);
        }

        Socket conexao = new Socket("localhost", 40000);
        ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

        saida.writeObject(requisicao);
        String resposta = (String) entrada.readObject();

        conexao.close();

        String[] parametros = resposta.split(";");
        if (parametros[0].equals("200")) {
            JOptionPane.showMessageDialog(null, "Resultado: " + parametros[1]);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    parametros[1],
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}