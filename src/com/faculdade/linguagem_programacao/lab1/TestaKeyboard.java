package com.faculdade.linguagem_programacao.lab1;


public class TestaKeyboard {
	public static void main(String[] args) {
		System.out.println("Digite a frase");
		String str = KeyBoard.readString();
		System.out.println("Frase: " + str);
		System.out.println("Digite um número inteiro");
		int i = KeyBoard.readInt();
		System.out.println("Int: " + i);
		System.out.println("Digite um double");
		double d = KeyBoard.readDouble();
		System.out.println("Double: " + d);
	}
}
