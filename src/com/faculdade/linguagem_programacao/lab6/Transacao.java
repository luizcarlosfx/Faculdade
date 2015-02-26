package com.faculdade.linguagem_programacao.lab6;

import java.text.DecimalFormat;
import java.util.Formatter;

public class Transacao {
	private double valor; 
	private int tipo;
	private Data data;
	public Transacao(double valor, int tipo, Data data) {
		super();
		this.valor = valor;
		this.tipo = tipo;
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("0.00");
		return "Data: " + data + " Tipo: " + TipoTransacao.byValue(tipo) + " Valor R$:" + formatter.format(valor);
	}
}
