package com.faculdade.linguagem_programacao.lab5;


public class Circulo {
	private double raio;
	private Ponto ponto;

	public Circulo(double raio, Ponto ponto) {
		super();
		this.ponto = ponto;
		this.raio = raio;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double calArea() {
		return Math.PI * raio * raio;
	}
	
	public void imprimir(){
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "raio " + raio + "\nPonto " + ponto;
	}

}
