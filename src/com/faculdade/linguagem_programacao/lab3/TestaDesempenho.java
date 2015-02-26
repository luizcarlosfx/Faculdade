package com.faculdade.linguagem_programacao.lab3;

public class TestaDesempenho {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Automovel automovel = new Automovel(1000, 10, new Combustivel(2.70), new Motor(2.0));
		System.out.println("Gasto médio = " + automovel.getPrecoMedio());
		System.out.println(automovel);
	}

}
