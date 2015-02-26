package com.faculdade.pesquisa_ordenacao.lab2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class TestaConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		Conta conta2 = new Conta(5, "Cliente", 1500);

		conta.depositar(1000);
		conta.sacar(1000);
		System.out.println(conta);

		List<Conta> contas = new ArrayList<Conta>();
		contas.add(new Conta(1, "Luiz Carlos", 1000));
		contas.add(new Conta(2, "Maria da Silva", 300));
		contas.add(new Conta(3, "Dilma Roussef", 750));
		contas.add(new Conta(4, "Maria Fernanda", 499));
		contas.add(conta);
		contas.add(conta2);

		listarContas(contas);
		double saldo = saldoTotal(contas);
		System.out.println("Saldo Total: " + saldo);

		exluirConta(conta, contas);
		listarContas(contas);

		exluirContas(4, contas);
		exluirContas(5, contas);
		listarContas(contas);

		imprimirContasComSaldoAcimaDe(500, contas);

	}

	private static void listarContas(List<Conta> contas) {
		System.out.println("Imprimindo todas as contas...");
		for (Conta conta : contas) {
			System.out.println(conta);
		}
		System.out.println("Impressão completa");
	}

	private static double saldoTotal(List<Conta> contas) {
		double saldo = 0;
		for (Conta conta : contas) {
			saldo += conta.getSaldo();
		}
		return saldo;
	}

	private static void exluirConta(Conta conta, List<Conta> contas) {
		contas.remove(conta);
	}

	private static void exluirContas(int numero, List<Conta> contas) {
		for (int i = 0; i < contas.size(); i++) {
			Conta conta = contas.get(i);
			if (conta.getNumero() == numero) {
				contas.remove(conta);
				i--;
			}
		}
	}

	private static void imprimirContasComSaldoAcimaDe(double saldo, List<Conta> contas) {
		System.out.println("Imprimindo contas com saldo acima de " + saldo + " ...");
		for (Conta conta : contas) {
			if (conta.getSaldo() > saldo) {
				System.out.println(conta);
			}
		}
		System.out.println("Impressão Completa!");
	}

}
