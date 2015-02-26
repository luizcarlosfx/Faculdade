package com.faculdade.games.lab2.armazem;

public class TesteArmazem
{
	public static void main(String[] args)
	{
		Pessoa luiz = new Pessoa("Luiz", "luizcarlos.sfx@gmail.com", "algum telefone");
		Pessoa romulo = new Pessoa("Romulo", "romulo@gmail.com", "algum telefone");
		Pessoa gerson = new Pessoa("Gerson", "gerson@gmail.com", "algum telefone");
		Pessoa varjao = new Pessoa("Daniel", "varjao@gmail.com", "algum telefone");

		RegistroPessoaArray array = new RegistroPessoaArray(10);

		array.armazenar(luiz).armazenar(romulo).armazenar(gerson).armazenar(varjao);
		
		array.imprime();
		
		array.remover("Luiz").remover("Romulo");
		
		array.imprime();
		
		RegistroPessoaArrayList arrayList = new RegistroPessoaArrayList();

		arrayList.armazenar(luiz).armazenar(romulo).armazenar(gerson).armazenar(varjao);
		
		arrayList.imprime();
		
		arrayList.remover("Luiz").remover("Romulo");
		
		arrayList.imprime();
		
		RegistroPessoaVector vector = new RegistroPessoaVector();

		vector.armazenar(luiz).armazenar(romulo).armazenar(gerson).armazenar(varjao);
		
		vector.imprime();
		
		vector.remover("Luiz").remover("Romulo");
		
		vector.imprime();
	}
}
