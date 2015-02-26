package com.faculdade.linguagem_programacao.lab6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Conta {
	private int codigo;
	private String nome;
	private double saldo;
	private List<Transacao> transacoes;
	
	public Conta(int codigo, String nome, double saldo) {
		super();
		this.transacoes = new ArrayList<>();
		this.codigo = codigo;
		this.nome = nome;
		this.saldo = saldo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public void realizarTransacao(Transacao transacao){
		transacoes.add(transacao);
	}
	
	public boolean sacar(double valor){
		Calendar calendar = Calendar.getInstance();
		if (podeSacar(valor)) {
			saldo -= valor;
			realizarTransacao(new Transacao(valor, TipoTransacao.SAQUE.getValue(), new Data(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.YEAR))));
			return true;
		}
		return false;
	}
	
	public void depositar(double valor){
		saldo += valor;
		Calendar calendar = Calendar.getInstance();
		realizarTransacao(new Transacao(valor, TipoTransacao.DEPOSITO.getValue(), new Data(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))));
	}
	
	public boolean podeSacar(double valor){
		return saldo - valor >= 0;
	}
	
	
	public void imprimir(){
		System.out.println(this);
	}
	
	public void printExtrato(){
		System.out.println(getExtrato());
	}
	public String getExtrato(){
		String extrato = "Conta: " + codigo + " - Cliente: " + nome + "\n";
		for (Transacao tr : transacoes) {
			extrato += tr + "\n";
		}
		return extrato;	
	}
	@Override
	public String toString() {
		return "Código: " + codigo + "\nNome: " + nome + "\nSaldo: " + saldo;
	}
}
