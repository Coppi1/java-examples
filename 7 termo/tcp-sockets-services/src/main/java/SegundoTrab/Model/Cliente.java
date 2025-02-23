package SegundoTrab.Model;

public class Cliente {
    private String usuario;
    private String senha;
    private String numeroConta;
    private double saldo;

    public Cliente(String usuario, String senha, String numeroConta, double saldo) {
        this.usuario = usuario;
        this.senha = senha;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}