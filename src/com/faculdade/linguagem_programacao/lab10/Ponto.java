package com.faculdade.linguagem_programacao.lab10;

public class Ponto extends Forma {
	public Ponto(float ax, float ay)

	{
		super(ax, ay);
	}

	// move não precisa ser redefinido
	public void mostra() {
		System.out.println(this.x + "," + this.y);
	}
}
