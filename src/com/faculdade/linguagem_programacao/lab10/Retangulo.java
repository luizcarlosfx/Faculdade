package com.faculdade.linguagem_programacao.lab10;

public class Retangulo extends Forma {
	private float dx, dy; // delta x e delta y

	public Retangulo(float ax, float ay, float dx, float dy)

	{
		super(ax, ay);
		this.dx = dx;
		this.dy = dy; // this usado para eliminar ambiguidade
	}

	public void mostra() {

		System.out.println(this.x + "," + this.y + " " + dx + "," + dy);
	}
}
