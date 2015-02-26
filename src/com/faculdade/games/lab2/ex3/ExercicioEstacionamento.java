package com.faculdade.games.lab2.ex3;

import javax.swing.JOptionPane;

public class ExercicioEstacionamento
{
	public static void main(String[] args)
	{
		float precoMinimo = 2.f;
		int minimoHoras = 3;
		float adicionalHora = 0.5f;

		float horas = Float.parseFloat(JOptionPane
				.showInputDialog("Quantas horas o carro ficou estacionado?"));

		long totalHoras = (long) Math.ceil(horas - minimoHoras);

		float total = precoMinimo;
		
		total += (totalHoras * adicionalHora);

		System.out.printf("Total R$%.2f", total);
	}
}
