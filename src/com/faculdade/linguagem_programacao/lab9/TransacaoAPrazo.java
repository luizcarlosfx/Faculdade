package com.faculdade.linguagem_programacao.lab9;

public class TransacaoAPrazo extends Transacao {

	private double juros;

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public TransacaoAPrazo(int codigo, String data, double juros) {
		super(codigo, data);
		this.juros = juros;
	}

	@Override
	public double calValor() {
		return super.calValor() + super.calValor() * (juros / 100);
	}

	@Override
	public String toString() {
		return "TransacaoAPrazo [juros=" + juros + "%" +  ", codigo=" + codigo + ", data=" + data
				+ ", calValor()=" + calValor() + ", calCMS()=" + calCMS() + "]";
	}
	
	
}
