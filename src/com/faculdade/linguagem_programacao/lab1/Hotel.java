package com.faculdade.linguagem_programacao.lab1;

import java.lang.Character.Subset;

public class Hotel {
	public static void main(String[] args) {
		System.out.println("entre com o nome");
		String nome = KeyBoard.readString();
		System.out.println("entre com o tipo de apartamento \nA, B, c ou D");
		String apt = KeyBoard.readString().trim().toUpperCase().substring(0, 1);
		System.out.println("Entre com o numeros de diárias");
		int diarias = KeyBoard.readInt();
		System.out.println("Entre com o valor do consumo interno");
		float conInterno = KeyBoard.readFloat();
		float totalDiarias = 0;
		float subtotal;
		float valorDaDiaria = 0;
		switch (apt) {
			case "A":
				valorDaDiaria = 150;
				break;
			case "B":
				valorDaDiaria = 100;
				break;
			case "C":
				valorDaDiaria = 75;
				break;
			case "D":
				valorDaDiaria = 50;
				break;
		}
		totalDiarias = diarias * valorDaDiaria;
		subtotal = totalDiarias + conInterno;
		float taxaDeServico = subtotal * 0.1f;
		float total = subtotal + taxaDeServico;

		System.out.println("Hospede: " + nome + "\nTipo de Apartamento " + apt + "\nDiárias " + diarias + "\nValor da Diária: " + valorDaDiaria
				+ "\nValor total das Diárias: " + totalDiarias + "\nConsumo Interno: " + conInterno + "\nTaxa de Serviço: " + taxaDeServico + "\nSubtotal: "
				+ subtotal + "\nTotal: " + total);
	}
}
