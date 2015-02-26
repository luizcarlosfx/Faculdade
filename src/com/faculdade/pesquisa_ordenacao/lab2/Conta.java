package com.faculdade.pesquisa_ordenacao.lab2;

public class Conta {

	private int numero;
	private String cliente;
	private double saldo;

	public Conta() {

	}

	public Conta(int numero, String cliente, double saldo) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void sacar(double valor) {
		if (valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo Insuficiente!");
		}
	}

	@Override
	public String toString() {
		return "Conta: " + numero + "\nCliente: " + cliente + "\nSaldo: " + saldo;
	}
}
