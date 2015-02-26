package com.faculdade.linguagem_programacao.lab5;

public class Ponto {
	private int x, y;

	public Ponto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void imprimir() {
		System.out.println(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}
}
