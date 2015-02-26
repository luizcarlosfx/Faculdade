package com.faculdade.games.lab2.armazem;

import java.util.ArrayList;
import java.util.Vector;

public class RegistroPessoaArrayList
{
	private ArrayList<Pessoa> pessoas;

	public RegistroPessoaArrayList()
	{
		pessoas = new ArrayList<Pessoa>();
	}

	public RegistroPessoaArrayList armazenar(Pessoa pessoa)
	{
		pessoas.add(pessoa);
		
		return this;
	}

	public RegistroPessoaArrayList remover(String nome)
	{
		pessoas.removeIf(p -> p.getNome().equals(nome));
		
		return this;
	}

	public void imprime()
	{
		System.out.println("Pessoas ArrayList");

		pessoas.forEach(this::imprimePessoa);

		System.out.println();
	}

	void imprimePessoa(Pessoa pessoa)
	{
		System.out.println(pessoa);
	}
}
