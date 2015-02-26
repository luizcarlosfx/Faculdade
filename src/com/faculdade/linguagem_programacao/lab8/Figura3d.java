package com.faculdade.linguagem_programacao.lab8;

public abstract class Figura3d extends Figura {
	protected double volume;

	public Figura3d(double lado) {
		super(lado);
	}

	@Override
	public String toString() {
		return "Figura3d [volume=" + volume + ", lado=" + lado + "]";
	}
	
	public abstract double calVolume();
	
}
