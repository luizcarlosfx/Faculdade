package com.faculdade.linguagem_programacao.lab4.part2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int codigo;
	private String cliente;
	private Data data;
	private List<ItemCompra> itensCompra;

	public Pedido(int codigo, String cliente, Data data) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.data = data;
		itensCompra = new ArrayList<ItemCompra>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItemCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
	
	public void addItem(ItemCompra compra){
		itensCompra.add(compra);
	}
	
	public void removeItem(ItemCompra compra){
		itensCompra.remove(compra);
	}

	public double calTotal() {
		double total = 0;
		for (ItemCompra itemCompra : itensCompra) {
			total += itemCompra.calcCustoItem();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + "\nData: " + data + "\nItems\n" + itensCompra + "\nTotal:\n"
				+ calTotal();
	}
}
