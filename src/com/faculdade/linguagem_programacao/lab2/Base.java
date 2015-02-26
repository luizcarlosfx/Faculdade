package com.faculdade.linguagem_programacao.lab2;

public class Base {
	private int a;
	private int b;

	public Base(int x, int y) {
		a = x;
		b = y;
	}
	
	public Base() {
		a = 0;
		b = 0;
	}

	public int getA() {
		return a;
	}

	public void setA(int x) {
		a = x;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void imprimir() {
		System.out.println("a  = " + a);
		System.out.println("b  = " + b);
	}

	public int soma() {
		return (a + b);
	}

	public boolean equals(Base otherBase) {
		return (otherBase.getA() == a && otherBase.b == b);
	}

}
// ///////////////////////////
