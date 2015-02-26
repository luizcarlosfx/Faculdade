package com.faculdade.topicos_especiais;

public class Polinomio
{
	private static float[] polinomio =
		{ -2, 5, 3 };

	public static void main(String[] args)
	{
		System.out.println(calculaPolinomio(3, polinomio));
	}

	private static float calculaPolinomio(float x, float[] array)
	{
		float total = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			total += array[i] * Math.pow(x, i);
		}

		return total;
	}
}
