package com.faculdade.linguagem_programacao.lab10;

//Classe Forma
abstract class Forma {
	
	protected float x, y; // visivel para classes abaixo

	public Forma(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void move(float dx, float dy) {
		this.x += dx;
		this.y += dy;
	}
	
}