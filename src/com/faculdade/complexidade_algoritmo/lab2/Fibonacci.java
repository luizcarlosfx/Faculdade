package com.faculdade.complexidade_algoritmo.lab2;

public class Fibonacci
{
	private static int fibo1Instructions;
	public static void main(String[] args)
	{
		long inicio = 0, fim = 0;
		
		inicio = System.nanoTime();
		int fibo1 = fibo1(30);
		fim = System.nanoTime();
		
		System.out.println("Fibo1: " + fibo1Instructions + " Instructions");
		System.out.println("Fibo 1: " + (fim - inicio));
		
		inicio = System.nanoTime();
		int fibo2 = fibo2(30);
		fim = System.nanoTime();
		
		System.out.println("Fibo 2: " + (fim - inicio));
		
	}
	public static int fibo1(int n)
	{
		if (n == 0 || n == 1)
		{
			fibo1Instructions += 3;
			return n;
		}
		else
		{
			fibo1Instructions += 2;
			return fibo1(n - 1) + fibo1(n - 2);
		}
	}

	public static int fibo2(int n)
	{
		int instructions = 2;
		if (n == 0 || n == 1)
		{
			System.out.println("Fibo2: " + instructions + " Instructions");
			return n;
		}
		else
		{
			int penultimo = 0, ultimo = 0, atual = 0;
			instructions += 3;
			for (int i = 2; i <= n; i++)
			{
				atual = penultimo + ultimo;
				penultimo = ultimo;
				ultimo = atual;
				instructions += 3;
			}

			System.out.println("Fibo2: " + instructions + " Instructions");
			return atual;
		}

	}
}
