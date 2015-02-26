package com.faculdade.linguagem_programacao.lab3;

public class A {
	private int a;
	private int b;
	private B b1;

	public A(int a, int b, B b1) {
		super();
		this.a = a;
		this.b = b;
		this.b1 = b1;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int somar() {
		System.out.println(this);
		return this.a + this.b + b1.somar();
	}
	
	@Override
	public String toString() {
		return "A = " + a + "\nB = " + b + b1.toString();
	}
}
