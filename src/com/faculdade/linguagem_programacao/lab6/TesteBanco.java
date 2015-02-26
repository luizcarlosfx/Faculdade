package com.faculdade.linguagem_programacao.lab6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TesteBanco {
	public static void main(String[] args) {
		String nome = "Luiz Carlos";
		int codigo = 0;
		double saldo = 250;
		Banco banco = new Banco("Santander", "teste");
		List<Conta> contas = new ArrayList<Conta>();
		
		for (int i = 0; i < 20; i++) {
			contas.add(new Conta(codigo++, nome+codigo, saldo));
			banco.addConta(contas.get(i));
			saldo *= 1.03;
		}
		
		for (Conta conta : contas) {
			conta.imprimir();
		}
		
		for (Conta conta : contas) {
			conta.depositar(Math.random() * 100);
			conta.sacar(Math.random() * 90);
		}
		System.out.println("\nExtrato");
		for (Conta conta : contas) {
			conta.printExtrato();
		}
		
		double b = banco.gerarBalancoMes(4);
		System.out.println("Total de Balanços do Mês - R$" + new DecimalFormat("0.00").format(b));
	}
}
