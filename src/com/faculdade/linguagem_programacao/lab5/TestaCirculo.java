package com.faculdade.linguagem_programacao.lab5;

public class TestaCirculo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ponto ponto = new Ponto(2, 4);
		Circulo circulo = new Circulo(5, ponto);
		System.out.println("Área	: " + circulo.calArea());
		circulo.imprimir();
	}

}
