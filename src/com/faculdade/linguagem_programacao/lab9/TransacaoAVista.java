package com.faculdade.linguagem_programacao.lab9;

public class TransacaoAVista extends Transacao{
	private double desconto;

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public TransacaoAVista(int codigo, String data, double desconto) {
		super(codigo, data);
		this.desconto = desconto;
	}
	
	@Override
	public double calValor() {
		// TODO Auto-generated method stub
		return super.calValor() - super.calValor() * (desconto/100);
	}

	@Override
	public String toString() {
		return "TransacaoAVista [desconto=" + desconto + "%" +  ", codigo=" + codigo + ", data=" + data
				+ ", calValor()=" + calValor() + ", calCMS()=" + calCMS() + "]";
	}
	
}
