package com.faculdade.linguagem_programacao.lab8;

public class Triangulo extends Figura2d {
	protected String tipo;

	public Triangulo(double lado, double alura, String tipo) {
		this.lado = lado;
		this.altura = alura;
		this.tipo = tipo;
	}
	
	public double calArea(){
		return (lado * altura) / 2;
	}

	@Override
	public String toString() {
		return "Triangulo [tipo=" + tipo + ", altura=" + altura + ", area=" + calArea() + ", lado="
				+ lado + "]";
	}
	
	
}
