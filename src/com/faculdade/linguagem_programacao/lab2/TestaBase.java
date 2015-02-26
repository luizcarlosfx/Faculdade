package com.faculdade.linguagem_programacao.lab2;

import com.faculdade.utilities.Objects;

public class TestaBase {
	public static void main(String arg[]) {
		Base b1, b2;
		b1 = new Objects<Base>(Base.class).inputNewObject();
		b2 = new Base();
		b2.setA(5);
		System.out.println("soma = " + b1.soma()); // (2)
		System.out.println("soma = " + b2.soma()); // (3)
		// b1.a= 5; // (4);
		b1.imprimir(); // (5);
		System.out.println(b1.equals(b2));
	}
}
