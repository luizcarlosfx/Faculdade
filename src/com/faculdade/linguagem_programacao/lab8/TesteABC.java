package com.faculdade.linguagem_programacao.lab8;

public class TesteABC {
	public static void main(String[] args) {
		A a = new A();
		a.a = 10;
		a.b = 20;
		System.out.println(a.somar());
		a.imprimir();
		
		B b = new B();
		b.a = 40;
		b.b = 1;
		b.c = 20;
		b.d = 50;
		
		System.out.println(b.somar());
		b.imprimir();
		
		C c = new C();
		c.a = 1;
		c.b = 2;
		c.c = 3;
		c.d = 4;
		c.e = 5;
		c.f = 6;
		
		System.out.println(c.somar());
		c.imprimir();
	}
}
