package com.faculdade.linguagem_programacao.lab6;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private String agencia;
	private List<Conta> contas;

	public Banco(String nome, String agencia) {
		super();
		contas = new ArrayList<>();
		this.nome = nome;
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void addConta(Conta conta) {
		contas.add(conta);
	}

	public void removeConta(Conta conta) {
		contas.remove(conta);
	}

	public void removeConta(int codigo) {
		for (Conta c : contas) {
			if (c.getCodigo() == codigo) {
				contas.remove(c);
			}
		}

		System.out.println("Nenhuma conta foi removida");
	}

	public double getTotalSaldos() {
		double saldoTotal = 0;
		for (Conta c : contas) {
			saldoTotal += c.getSaldo();
		}
		return saldoTotal;
	}
	
	public void printSaldoAcimaDe(double saldo){
		for (Conta c : contas) {
			if(c.getSaldo() > saldo){
				c.imprimir();
			}
		}
	}
	
	public void mostraDadosContaMenorSaldo(){
		Conta menorSaldo = contas.get(0);
		for (int i = 1; i < contas.size(); i++) {
			if (contas.get(i).getSaldo() < menorSaldo.getSaldo()) {
				menorSaldo = contas.get(i);
			}
		}
		menorSaldo.imprimir();
	}
	
	public double gerarBalancoMes(int mes){
		double totalMes = 0;
		for (Conta c : contas) {
			for (Transacao t : c.getTransacoes()) {
				if (t.getData().getMes() == mes) {
					totalMes += t.getValor();
				}
			}
		}
		return totalMes;
	}
}
