package com.faculdade.linguagem_programacao.lab4.part2;

public class ItemCompra {
	private int codigo;
	private String nome;
	private int quantidade;
	private double preco;

	public ItemCompra(int codigo, String nome, int quantidade, double preço) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preço;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preço) {
		this.preco = preço;
	}
	
	public double calcCustoItem() {
		return preco * quantidade;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "\nNome: " + nome + "\nPreço: " + preco + "\nQuantidade: "
				+ quantidade;
	}
}
