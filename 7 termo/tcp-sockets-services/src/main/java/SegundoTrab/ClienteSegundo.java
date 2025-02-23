import Utils.ClienteCriptografiaUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ClienteSegundo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}

class LoginFrame extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Usuário:"));
        usuarioField = new JTextField();
        panel.add(usuarioField);

        panel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        panel.add(senhaField);

        JButton loginButton = new JButton("Entrar");
        loginButton.addActionListener(this::loginAction);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private void loginAction(ActionEvent e) {
        String usuario = usuarioField.getText();
        String senha = new String(senhaField.getPassword());

        String senhaCriptografada = ClienteCriptografiaUtils.criptografar(senha);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    Socket socket = new Socket("localhost", 12345);
                    ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                    saida.writeObject(usuario);
                    saida.writeObject(senhaCriptografada);
                    String resposta = (String) entrada.readObject();

                    SwingUtilities.invokeLater(() -> {
                        if (resposta.startsWith("ERRO")) {
                            JOptionPane.showMessageDialog(LoginFrame.this, resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                        } else {
                            dispose();
                            new MainFrame(socket, saida, entrada).setVisible(true);
                        }
                    });
                } catch (IOException | ClassNotFoundException ex) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(LoginFrame.this, "Erro de conexão com o servidor", "Erro", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    });
                }
                return null;
            }
        }.execute();
    }
}

class MainFrame extends JFrame {
    private final Socket socket;
    private final ObjectOutputStream saida;
    private final ObjectInputStream entrada;
    private JButton depositarButton, sacarButton, consultarButton, sairButton;

    public MainFrame(Socket socket, ObjectOutputStream saida, ObjectInputStream entrada) {
        this.socket = socket;
        this.saida = saida;
        this.entrada = entrada;

        setTitle("Caixa Eletrônico");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sair();
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        depositarButton = new JButton("Depositar");
        depositarButton.addActionListener(this::depositarAction);
        panel.add(depositarButton);

        sacarButton = new JButton("Sacar");
        sacarButton.addActionListener(this::sacarAction);
        panel.add(sacarButton);

        consultarButton = new JButton("Consultar Saldo");
        consultarButton.addActionListener(this::consultarAction);
        panel.add(consultarButton);

        sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> sair());
        panel.add(sairButton);

        add(panel);
    }

    private void setButtonsEnabled(boolean enabled) {
        depositarButton.setEnabled(enabled);
        sacarButton.setEnabled(enabled);
        consultarButton.setEnabled(enabled);
        sairButton.setEnabled(enabled);
    }

    private void depositarAction(ActionEvent e) {
        JTextField contaField = new JTextField();
        JTextField valorField = new JTextField();
        Object[] message = {"Número da conta:", contaField, "Valor a depositar:", valorField};

        int option = JOptionPane.showConfirmDialog(this, message, "Depositar", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            enviarComando("DEPOSITAR " + contaField.getText() + " " + valorField.getText());
        }
    }

    private void sacarAction(ActionEvent e) {
        JTextField valorField = new JTextField();
        Object[] message = {"Valor a sacar:", valorField};

        int option = JOptionPane.showConfirmDialog(this, message, "Sacar", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            enviarComando("SACAR " + valorField.getText());
        }
    }

    private void consultarAction(ActionEvent e) {
        enviarComando("CONSULTAR_SALDO");
    }

    private void enviarComando(String comando) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    SwingUtilities.invokeLater(() -> setButtonsEnabled(false));
                    saida.writeObject(comando);
                    String resposta = (String) entrada.readObject();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(MainFrame.this, resposta);
                    });
                } catch (IOException | ClassNotFoundException ex) {
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(MainFrame.this, "Erro na comunicação com o servidor", "Erro", JOptionPane.ERROR_MESSAGE);
                    });
                } finally {
                    SwingUtilities.invokeLater(() -> setButtonsEnabled(true));
                }
                return null;
            }
        }.execute();
    }

    private void sair() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try {
                    saida.writeObject("SAIR");
                    entrada.close();
                    saida.close();
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                dispose();
                System.exit(0);
            }
        }.execute();
    }
}