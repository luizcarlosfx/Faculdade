package com.faculdade.linguagem_programacao.lab10;

public class Quadrado implements Shape {

	private double lado;

	public Quadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double calArea() {
		return lado * lado;
	}

	@Override
	public double calPerimetro() {
		return 4 * lado;
	}

	@Override
	public double calDiagonal() {
		return Math.sqrt((lado * lado) + (lado * lado));
	}

	@Override
	public void imprimir() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Quadrado [lado=" + lado + ", Area()=" + calArea() + ", Perimetro()="
				+ calPerimetro() + ", Diagonal()=" + calDiagonal() + "]";
	}

}
