package com.faculdade.linguagem_programacao.lab8;

public class Paralelepipido extends Figura3d {
	private double alt_base, altura;

	public Paralelepipido(double lado, double alt_base, double altura) {
		super(lado);
		this.alt_base = alt_base;
		this.altura = altura;
	}
	
	public double calVolume(){
		return (volume = alt_base * lado * altura);
	}

	@Override
	public String toString() {
		return "Paralelepipido [alt_base=" + alt_base + ", altura=" + altura + ", volume=" + calVolume()
				+ ", lado=" + lado + "]";
	}
}
