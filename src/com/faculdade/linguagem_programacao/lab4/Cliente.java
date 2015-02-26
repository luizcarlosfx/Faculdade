package com.faculdade.linguagem_programacao.lab4;

public class Cliente {
	private String nome;
	private String endereco;
	private Pedido pedido;

	public Cliente(String nome, String endereco, Pedido pedido) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.pedido = pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nEndereço: " + endereco + "\nPedido\n" + pedido;
	}

}
