package com.faculdade.linguagem_programacao.lab2;

public class Ponto {
	private double x;
	private double y;

	public Ponto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Ponto() {
		this.x = 0;
		this.y = 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void moveX(double newPosition) {
		this.x = newPosition;

	}

	public void moveY(double newPosition) {
		this.y = newPosition;

	}

	public boolean xEqualsY() {
		return x == y;
	}

	public double distanceBetweenXAndY() {
		return Math.abs(x - y);
	}
}
