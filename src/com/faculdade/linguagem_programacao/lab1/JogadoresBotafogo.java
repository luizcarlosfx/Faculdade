package com.faculdade.linguagem_programacao.lab1;

public class JogadoresBotafogo {
	public static void main(String[] args) {
		System.out.println("Entre com o salário");
		double salario = KeyBoard.readDouble();
		double novoSalario = salario;
		if (salario <= 1000) {
			novoSalario = salario + (salario * 0.2);
		}else if (salario <= 5000 ) {
			novoSalario = salario + (salario * 0.1);
		}
		
		System.out.println("Novo Salário = " + novoSalario);
	}
}
