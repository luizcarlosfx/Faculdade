package com.faculdade.computacaografica.lab1;

import java.awt.Dimension;

public class DesenhaObjetos
{
	public static void main(String[] args)
	{
//		new Janela("Carro", new PainelCarro());
//		
//		new Janela("Triangulo", new PainelTriangulo());
		
		new Janela("Quadrados", new SquaresPanel(new Dimension(1300, 700)));
	}
}
