package com.faculdade.linguagem_programacao.lab5;

public class Pedido {
	protected int codigo;
	protected double valor;
	protected String cliente;

	public Pedido(int codigo, String cliente) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void calValor() {
		// faz alguma coisa
	}

	public double calCMS() {
		// faz alguma coisa
		return 0;
	}

}
