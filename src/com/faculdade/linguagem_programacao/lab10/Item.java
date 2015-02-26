package com.faculdade.linguagem_programacao.lab10;

public class Item {
	private int quantidade;
	private int tamanho;
	private double preco;
	
	public Item(int quantidade, int tamanho, double preco) {
		super();
		this.quantidade = quantidade;
		this.tamanho = tamanho;
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double calValor(){
		return quantidade * preco;
	}

	
	@Override
	public String toString() {
		return "Item [quantidade=" + quantidade + ", tamanho=" + tamanho + ", preco=" + preco
				+ ", calValor()=" + calValor() + "]";
	}
}
