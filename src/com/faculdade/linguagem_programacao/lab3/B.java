package com.faculdade.linguagem_programacao.lab3;

public class B {
	private int c;
	private int d;
	private C c1;

	public B(int c, int d, C c1) {
		super();
		this.c = c;
		this.d = d;
		this.c1 = c1;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int somar() {
		return this.c + this.d + c1.somar();
	}

	@Override
	public String toString() {
		return "\nC = " + c + "\nD = " + d + c1.toString();
	}
}
