package com.faculdade.linguagem_programacao.lab8;

public class Trapezio extends Figura2d {
	protected double base;

	public Trapezio(double lado, double alura, double base) {
		super(lado, alura);
		this.base = base;
	}
	
	
	public double calArea(){
		return area = (base + lado) * altura / 2;
	}


	@Override
	public String toString() {
		return "Trapezio [base=" + base + ", altura=" + altura + ", area=" + calArea() + ", lado="
				+ lado + "]";
	}
	
	
}
