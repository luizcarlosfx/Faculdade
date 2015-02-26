package com.faculdade.linguagem_programacao.lab3;

public class C {
	private int e;
	private int f;

	public C(int e, int f) {
		super();
		this.e = e;
		this.f = f;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int somar() {
		return e + f;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nE = " + e + "\nF = " + f;
	}
}
