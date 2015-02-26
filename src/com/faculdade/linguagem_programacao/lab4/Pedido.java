package com.faculdade.linguagem_programacao.lab4;

public class Pedido {
	private int codigo;
	private Data data;
	private ItemCompra itemCompra;

	public Pedido(int codigo, Data data, ItemCompra itemCompra) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.itemCompra = itemCompra;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public ItemCompra getItemCompra() {
		return itemCompra;
	}

	public void setItemCompra(ItemCompra itemCompra) {
		this.itemCompra = itemCompra;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "\nData: " + data + "\nItem\n" + itemCompra + "\nTotal: "
				+ calcularValor();
	}

	public double calcularValor() {
		return itemCompra.getPreco() * itemCompra.getQuantidade();
	}
}
