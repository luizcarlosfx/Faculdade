package com.faculdade.games.lab2.armazem;

public class RegistroPessoaArray
{
	private Pessoa[] pessoas;

	public RegistroPessoaArray(int size)
	{
		pessoas = new Pessoa[size];
	}

	public RegistroPessoaArray armazenar(Pessoa pessoa)
	{
		int index = getFreeIndex();

		if (index == -1)
		{
			System.out.println("Limite estourado");
		}
		else
		{
			pessoas[index] = pessoa;
		}

		return this;
	}

	private int getFreeIndex()
	{
		for (int i = 0; i < pessoas.length; i++)
		{
			if (pessoas[i] == null)
				return i;
		}

		return -1;
	}

	public RegistroPessoaArray remover(String nome)
	{
		for (int i = 0; i < pessoas.length; i++)
		{
			if (pessoas[i] != null && pessoas[i].getNome().equals(nome))
			{
				pessoas[i] = null;
			}
		}

		return this;
	}

	public void imprime()
	{
		System.out.println("Pessoas Array");

		for (Pessoa pessoa : pessoas)
		{
			if (pessoa != null)
				System.out.println(pessoa.toString());
		}

		System.out.println();
	}
}
