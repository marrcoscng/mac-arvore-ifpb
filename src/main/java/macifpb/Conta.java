package macifpb;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numeroConta;
    private double saldo;
    private List<String> extrato;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.extrato = new ArrayList<>();
        this.extrato.add("Conta criada com saldo inicial de: R$ " + String.format("%.2f", saldoInicial));
    }

    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            extrato.add("Saque realizado: - R$ " + String.format("%.2f", valor));
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            extrato.add("Depósito realizado: + R$ " + String.format("%.2f", valor));
        }
    }

    public void exibirExtrato() {
        System.out.println("\n--- EXTRATO DA CONTA " + numeroConta + " ---");
        for (String operacao : extrato) {
            System.out.println("- " + operacao);
        }
        System.out.printf("Saldo Atual: R$ %.2f\n", saldo);
    }
}
