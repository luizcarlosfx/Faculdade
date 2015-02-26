package com.faculdade.linguagem_programacao.lab3;

public class Combustivel {
	private double preco;

	public Combustivel(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "\nPreço = " + preco;
	}
}
