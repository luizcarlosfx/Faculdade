package com.faculdade.linguagem_programacao.lab8;

public class Esfera extends Figura3d {
	private double raio;

	public Esfera(double lado, double volume, double raio) {
		super(lado);
		this.raio = raio;
	}

	public double calVolume() {
		return (volume =  (4 * Math.PI * Math.pow(raio, 2)) / 3);
	}

	@Override
	public String toString() {
		return "Esfera [raio=" + raio + ", volume=" + calVolume() + ", lado=" + lado + "]";
	}
	
	
}
