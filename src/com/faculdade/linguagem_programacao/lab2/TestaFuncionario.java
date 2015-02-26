package com.faculdade.linguagem_programacao.lab2;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(1234, "Pedro", 40);
		Funcionario f2 = new Funcionario(5678, "Ana", 30);
		f1.calculaSalario();
		f2.calculaSalario();
		System.out.println(f1);
		String message = Funcionario.quemGanhaMais(f1,f2).getNome();
		System.out.println(message);
		Funcionario f3 = new Funcionario();
	}
}
