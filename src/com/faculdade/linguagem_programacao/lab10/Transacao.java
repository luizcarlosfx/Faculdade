package com.faculdade.linguagem_programacao.lab10;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
	protected int codigo;
	protected String data;
	private List<Item> itens;
	
	public Transacao(int codigo, String data) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.itens = new ArrayList<>();
	}
	
	public List<Item> getItem() {
		return itens;
	}
	
	public double calValor(){
		double valor = 0;
		for (Item item : itens) {
			valor += item.calValor();
		}
		return valor;
	}
	
	public double calCMS(){
		return calValor() * .25;
	}
	
	public void addItem(Item item){
		itens.add(item);
	}
	
	public void Imprimir(){
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Transacao [codigo=" + codigo + ", data=" + data + ", itens=" + itens
				+ ", calValor()=" + calValor() + ", calCMS()=" + calCMS() + "]";
	}
	
	
}
