package com.faculdade.linguagem_programacao.lab2;

public class TestePonto {
	public static void main(String[] args) {
		Ponto ponto = new Ponto();
		Ponto ponto2 = new Ponto(2, 3);
		
		System.out.println(ponto.distanceBetweenXAndY());
		System.out.println(ponto2.distanceBetweenXAndY());
		System.out.println(ponto.xEqualsY());
		System.out.println(ponto2.xEqualsY());
		
		ponto.moveX(5);
		ponto2.moveY(5);
		
		System.out.println(ponto.distanceBetweenXAndY());
		System.out.println(ponto2.distanceBetweenXAndY());
		System.out.println(ponto.xEqualsY());
		System.out.println(ponto2.xEqualsY());
	}
}
