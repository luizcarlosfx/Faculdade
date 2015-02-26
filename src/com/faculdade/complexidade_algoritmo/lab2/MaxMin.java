package com.faculdade.complexidade_algoritmo.lab2;

import com.faculdade.complexidade_algoritmo.lab1.Sort;

public class MaxMin
{
	public static void main(String[] args)
	{
		int [] array = Sort.inverseArray(1000);
		maxMin1(array);
		maxMin2(array);
		maxMin3(array);
	}

	public static void maxMin1(int[] list)
	{
		int instructions = 2;
		int max = list[0], min = list[0];

		for (int i = 1; i < list.length; i++)
		{
			max = (list[i] > max) ? list[i] : max;
			min = (list[i] < min) ? list[i] : min;

			instructions += 4;
		}

		System.out.println("Primeiro: " + instructions);
	}

	public static void maxMin2(int[] list)
	{
		int instructions = 2;
		int max = list[0], min = list[0];

		for (int i = 1; i < list.length; i++)
		{
			if (list[i] > max)
			{
				max = list[i];
			}
			else if (list[i] < min)
			{
				min = list[i];
			}

			instructions += 3;
		}

		System.out.println("Segundo: " + instructions);
	}

	public static void maxMin3(int[] list)
	{
		int instructions = 0, fimDoAnel = 0, min = 0, max = 0, index = 2;

		int n = list.length - 2;

		if ((list.length % 2) > 0)
		{
			list[n + 1] = list[n];
			fimDoAnel = n;
		}
		else
		{
			fimDoAnel = n - 1;
		}

		instructions += 3;

		if (list[0] > list[1])
		{
			max = list[0];
			min = list[1];
		}
		else
		{
			max = list[1];
			min = list[0];
		}
		
		instructions += 3;

		while (index <= fimDoAnel)
		{
			instructions += 5;
			if (list[index] > list[index + 1])
			{
				if (list[index] > max)
					max = list[index];
				if (list[index + 1] < min)
					min = list[index + 1];
			}
			else
			{
				if (list[index] < min)
					min = list[index];
				if (list[index + 1] > max)
					max = list[index + 1];
			}
			
			index += 2;
		}

		instructions += 3;

		System.out.println("Terceiro: " + instructions);
	}
}
