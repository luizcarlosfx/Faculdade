package com.faculdade.games.lab5;

import java.util.ArrayList;
import java.util.List;

public class Miojo
{
	public static void main(String[] args)
	{
		int tempo = fazerMiojo(4, 4, 9);

		if (tempo != -1)
		{
			System.out.printf("\nTempo total para o preparo: %s minutos.\n", tempo);
		}
		else
		{
			System.out.println("Não foi possível fazer o miojo");
		}
	}

	static int fazerMiojo(int ampulheta1, int ampulheta2, int tempoPreparo)
	{
		List<Estado> estados = new ArrayList<Estado>();

		Ampulheta a1 = new Ampulheta(ampulheta1);
		Ampulheta a2 = new Ampulheta(ampulheta2);

		Estado atual = new Estado(a1, a2);

		int total = tempoPreparo;

		while (a1.atual != tempoPreparo && a2.atual != tempoPreparo && !estados.contains(atual))
		{
			estados.add(atual);

			Ampulheta menor = a1.atual < a2.atual ? a1 : a2;

			int menorValor = menor.atual;

			a1.virar(menorValor);
			a2.virar(menorValor);

			total += menorValor;

			atual = new Estado(a1, a2);
		}

		estados.add(atual);

		for (Estado estado : estados)
		{
			System.out.printf("[%s, %s]\n", estado.a1, estado.a2);
		}
		
		if (a1.atual == tempoPreparo || a2.atual == tempoPreparo)
		{
			return total;
		}
		else
		{
			return -1;
		}
	}
}

class Estado
{
	int a1;
	int a2;

	public Estado(Ampulheta a1, Ampulheta a2)
	{
		super();
		this.a1 = a1.atual;
		this.a2 = a2.atual;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + a1;
		result = prime * result + a2;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (a1 != other.a1)
			return false;
		if (a2 != other.a2)
			return false;
		return true;
	}
}

class Ampulheta
{
	int tamanho;
	int atual;

	public Ampulheta(int tamanho)
	{
		super();
		this.tamanho = tamanho;
		this.atual = tamanho;
	}

	void virar(int tempo)
	{
		atual -= tempo;

		if (atual <= 0)
		{
			atual = tamanho;
		}
	}

	@Override
	public String toString()
	{
		return "Ampulheta [tamanho=" + tamanho + ", atual=" + atual + "]";
	}
}