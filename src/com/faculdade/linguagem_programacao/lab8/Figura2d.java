package com.faculdade.linguagem_programacao.lab8;

public abstract class Figura2d extends Figura {

	protected double altura;
	protected double area;
	
	public Figura2d() {
	}
	public Figura2d(double lado, double altura) {
		super(lado);
		this.altura = altura;
	}
	
	public abstract double calArea();
	
	@Override
	public String toString() {
		return "Figura2d [altura=" + altura + ", area=" + area + ", lado=" + lado + "]";
	}
	
	

}
