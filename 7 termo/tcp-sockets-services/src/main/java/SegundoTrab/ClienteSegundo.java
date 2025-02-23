package SegundoTrab;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSegundo {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Bem-vindo ao Caixa Eletrônico!");

            // Autenticação
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            saida.writeObject(usuario);
            saida.writeObject(senha);

            String resposta = (String) entrada.readObject();
            System.out.println(resposta);

            if (resposta.startsWith("ERRO")) {
                return;
            }

            while (true) {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Consultar Saldo");
                System.out.println("4 - Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o número da conta e o valor a depositar: ");
                        String[] deposito = scanner.nextLine().split(" ");
                        saida.writeObject("DEPOSITAR " + deposito[0] + " " + deposito[1]);
                        break;
                    case 2:
                        System.out.print("Informe o valor a sacar: ");
                        String valorSaque = scanner.nextLine();
                        saida.writeObject("SACAR " + valorSaque);
                        break;
                    case 3:
                        saida.writeObject("CONSULTAR_SALDO");
                        break;
                    case 4:
                        saida.writeObject("SAIR");
                        System.out.println("Conexão encerrada. Obrigado por usar o Caixa Eletrônico!");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }

                resposta = (String) entrada.readObject();
                System.out.println(resposta);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}