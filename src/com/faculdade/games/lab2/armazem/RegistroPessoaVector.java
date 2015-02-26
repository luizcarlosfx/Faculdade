package com.faculdade.games.lab2.armazem;

import java.util.Vector;

public class RegistroPessoaVector
{
	private Vector<Pessoa> pessoas;

	public RegistroPessoaVector()
	{
		pessoas = new Vector<Pessoa>();
	}
	
	public RegistroPessoaVector armazenar(Pessoa pessoa)
	{
		pessoas.add(pessoa);
		
		return this;
	}

	public RegistroPessoaVector remover(String nome)
	{
		pessoas.removeIf(p -> p.getNome().equals(nome));
		
		return this;
	}
	
	public void imprime()
	{
		System.out.println("Pessoas Vector");
		
		pessoas.forEach(this::imprimePessoa);
		
		System.out.println();
	}
	
	void imprimePessoa(Pessoa pessoa)
	{
		System.out.println(pessoa);
	}
}
