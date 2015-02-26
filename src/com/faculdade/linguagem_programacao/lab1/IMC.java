package com.faculdade.linguagem_programacao.lab1;

import javax.swing.JOptionPane;

public class IMC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Entre com o peso");
		double peso = KeyBoard.readDouble();
		System.out.println("entre com a altura");
		double altura = KeyBoard.readDouble();
		double imc =  peso/(altura * altura);
		
		if (imc < 26) {
			System.out.println("Normal");
		}else if (imc < 30) {
			System.out.println("Obeso");
		}else{
			System.out.println("Obeso Morbido");
		}
		
	}

}
