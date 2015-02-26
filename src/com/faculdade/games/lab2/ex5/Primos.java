package com.faculdade.games.lab2.ex5;

public class Primos
{
	public static void main(String[] args)
	{
		int[] numeros = new int[998];

		for (int i = 0; i < numeros.length; i++)
		{
			numeros[i] = i + 2;
		}

		for (int numero : numeros)
		{
			if (isPrime(numero))
			{
				System.out.println(String.format("%s é um número primo", numero));
			}
		}
	}

	static boolean isPrime(int number)
	{
		if (number % 2 == 0 && number != 2)
			return false;

		for (int i = 3; i < number; i += 2)
		{
			if (number % i == 0 && i != number)
				return false;
		}
		
		return true;
	}
}
