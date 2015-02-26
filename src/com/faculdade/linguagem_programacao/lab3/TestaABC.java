package com.faculdade.linguagem_programacao.lab3;

public class TestaABC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A(1, 2, new B(1, 2, new C(1, 2)));
		System.out.println("Soma = " + a.somar());
	}
}
