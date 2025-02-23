package SegundoTrab;

import SegundoTrab.Model.Cliente;
import Utils.ServerCriptografiaUtils;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorSegundo {
    private static final int PORTA = 12345;
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static final String ARQUIVO_LOG = "servidor.log";

    public static void main(String[] args) {
        clientes.put("1001", new Cliente("user1", "pass1", "1001", 5000.0));
        clientes.put("1002", new Cliente("user2", "pass2", "1002", 3000.0));

        try (ServerSocket servidorSocket = new ServerSocket(PORTA)) {
            System.out.println("Servidor iniciado na porta " + PORTA);

            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());
                new Thread(new ClienteHandler(clienteSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registrarLog(String mensagem) {
        try (FileWriter fw = new FileWriter(ARQUIVO_LOG, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(timestamp + " - " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClienteHandler implements Runnable {
        private Socket clienteSocket;
        private Cliente clienteAutenticado;

        public ClienteHandler(Socket socket) {
            this.clienteSocket = socket;
        }

        @Override
        public void run() {
            try (ObjectOutputStream saida = new ObjectOutputStream(clienteSocket.getOutputStream());
                  ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream())) {

                // Autenticação
                String usuario = (String) entrada.readObject();

                String senhaCriptografada = (String) entrada.readObject();

                registrarLog("Senha Criptografada: "+ senhaCriptografada);

                String senha = ServerCriptografiaUtils.descriptografar(senhaCriptografada);

                clienteAutenticado = autenticar(usuario, senha);
                if (clienteAutenticado == null) {
                    String erro = "ERRO: Autenticação falhou. Usuário ou senha incorretos.";
                    saida.writeObject(erro);
                    registrarLog(erro + " (Usuário: " + usuario + ")");
                    return;
                }
                saida.writeObject("Autenticação bem-sucedida!");
                registrarLog("Usuário " + usuario + " autenticado com sucesso.");

                while (true) {
                    String operacao = (String) entrada.readObject();
                    String[] partes = operacao.split(" ");
                    String resposta;

                    switch (partes[0].toUpperCase()) {
                        case "DEPOSITAR":
                            resposta = depositar(partes[1], Double.parseDouble(partes[2]));

                            if (resposta.startsWith("ERRO")) {
                                registrarLog(resposta + " (Usuário: " + clienteAutenticado.getUsuario() + ")");
                            } else {
                                registrarLog("Depósito de R$ " + partes[2] + " na conta " + partes[1] + " realizado por " + clienteAutenticado.getUsuario());
                            }
                            break;
                        case "SACAR":
                            resposta = sacar(Double.parseDouble(partes[1]));
                            // Log para saque (sucesso ou erro)
                            if (resposta.startsWith("ERRO")) {
                                registrarLog(resposta + " (Usuário: " + clienteAutenticado.getUsuario() + ")");
                            } else {
                                registrarLog("Saque de R$ " + partes[1] + " realizado por " + clienteAutenticado.getUsuario());
                            }
                            break;
                        case "CONSULTAR_SALDO":
                            resposta = consultarSaldo();
                            registrarLog("Consulta de saldo realizada por " + clienteAutenticado.getUsuario());
                            break;
                        case "SAIR":
                            saida.writeObject("Conexão encerrada. Obrigado por usar o Caixa Eletrônico!");
                            registrarLog("Usuário " + clienteAutenticado.getUsuario() + " desconectou.");
                            return;
                        default:
                            resposta = "ERRO: Operação inválida.";
                            registrarLog("Tentativa de operação inválida por " + clienteAutenticado.getUsuario());
                    }
                    saida.writeObject(resposta);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    clienteSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Operações

        private String depositar(String numeroConta, double valor) {
            if (valor <= 0) {
                return "ERRO: Valor de depósito inválido.";
            }
            Cliente cliente = clientes.get(numeroConta);
            if (cliente == null) {
                return "ERRO: Conta de destino inválida.";
            }
            cliente.depositar(valor);
            return "Depósito realizado com sucesso!";
        }

        private String sacar(double valor) {
            if (valor <= 0) {
                return "ERRO: Valor de saque inválido.";
            }
            if (clienteAutenticado.getSaldo() < valor) {
                return "ERRO: Saldo insuficiente.";
            }
            clienteAutenticado.sacar(valor);
            return "Saque realizado com sucesso!";
        }

        private String consultarSaldo() {
            return "Saldo da conta " + clienteAutenticado.getNumeroConta() + ": R$ " + clienteAutenticado.getSaldo();
        }

        private Cliente autenticar(String usuario, String senha) {
            for (Cliente cliente : clientes.values()) {
                if (cliente.getUsuario().equals(usuario) && cliente.getSenha().equals(senha)) {
                    return cliente;
                }
            }
            return null;
        }
    }
}