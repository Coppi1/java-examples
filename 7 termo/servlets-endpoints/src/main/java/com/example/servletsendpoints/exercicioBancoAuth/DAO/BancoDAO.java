package com.example.servletsendpoints.exercicioBancoAuth.DAO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BancoDAO {
    private static final Map<String, Double> saldos = new ConcurrentHashMap<>();

    static {
        saldos.put("1001", 1000.00);
        saldos.put("2002", 1000.00);
        saldos.put("3003", 1000.00);
    }

    public static synchronized double getSaldo(String conta) {
        return saldos.getOrDefault(conta, 0.0);
    }

    public static synchronized void depositar(String conta, double valor) {
        saldos.put(conta, saldos.get(conta) + valor);
    }

    public static synchronized boolean sacar(String conta, double valor) {
        double saldoAtual = saldos.get(conta);
        if (valor > saldoAtual) {
            return false;
        }
        saldos.put(conta, saldoAtual - valor);
        return true;
    }
}