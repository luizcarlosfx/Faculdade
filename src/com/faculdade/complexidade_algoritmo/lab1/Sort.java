package com.faculdade.complexidade_algoritmo.lab1;

import java.util.Arrays;

public class Sort
{

	public static void main(String[] args)
	{
		int[] v = inverseArray(1000);
		int[] v2 = v.clone();
		int[] v3 = v.clone();

		bubblesort(v);
		selectionSort(v2);
		insertion(v3);
	}

	public static void quick_sort(int[] v, int ini, int fim)
	{
		int meio;
		if (ini < fim)
		{
			meio = partition(v, ini, fim);
			quick_sort(v, ini, meio);
			quick_sort(v, meio + 1, fim);
		}
	}

	public static int partition(int[] v, int ini, int fim)
	{
		int pivo, topo, i;
		pivo = v[ini];
		topo = ini;

		for (i = ini + 1; i < fim; i++)
		{
			if (v[i] < pivo)
			{
				v[topo] = v[i];
				v[i] = v[topo + 1];
				topo++;
			}
		}
		v[topo] = pivo;
		return topo;
	}

	public static void bubblesort(int vetor[])
	{
		int instructions = 0;
		int temp;
		boolean alterado = true;

		instructions += 2;
		while (alterado)
		{
			temp = 0;
			alterado = false;

			instructions += 2;
			for (int j = 0; j < vetor.length - 1; j++)
			{
				if (vetor[j] > vetor[j + 1])
				{
					temp = vetor[j + 1];
					vetor[j + 1] = vetor[j];
					vetor[j] = temp;
					alterado = true;
				}
				instructions += 5;
			}
		}
		System.out.println("Bubble: " + instructions + " instructions");
	}

	public static void selectionSort(int[] vetor)
	{
		int instructions = 0;
		int minimo, temp;

		for (int i = 0; i < vetor.length; i++)
		{
			minimo = i;
			instructions += 1;
			for (int j = i + 1; j < vetor.length; j++)
			{
				if (vetor[j] < vetor[minimo])
				{
					minimo = j;
				}
				instructions += 2;
			}
			if (minimo != i)
			{
				temp = vetor[minimo];
				vetor[minimo] = vetor[i];
				vetor[i] = temp;
			}
			instructions += 4;
		}
		
		System.out.println("Selection: " + instructions + " instructions");
	}

	public static void shellsort(int nums[])
	{
		int n = nums.length;
		int h = n / 2;
		int c, j;
		while (h > 0)
		{
			for (int i = h; i < n; i++)
			{
				c = nums[i];
				j = i;
				while (j >= h && nums[j - h] > c)
				{
					nums[j] = nums[j - h];
					j = j - h;
				}
				nums[j] = c;
			}
			h = h / 2;
		}
	}

	public static void insertion(int nums[])
	{
		int instructions = 0;
		for (int i = 1; i < nums.length; i++)
		{
			int a = nums[i];
			int j;
			instructions += 1;
			for (j = i - 1; j >= 0 && nums[j] > a; j--)
			{
				nums[j + 1] = nums[j];
				nums[j] = a;
				instructions += 2;
			}
		}
		
		System.out.println("Insert: " + instructions + " instructions");

	}

	public static int[] randomArray(int tam)
	{

		int[] iArray = new int[tam];

		for (int i = 0; i < iArray.length; i++)
		{
			iArray[i] = (int) (Math.random() * tam + 1);
		}

		return iArray;
	}

	public static int[] inverseArray(int tam)
	{
		int[] iArray = new int[tam];

		for (int i = 0; i < iArray.length; i++)
		{
			iArray[i] = 1000 - i;
		}

		return iArray;
	}

	public static void javaSort(int[] array)
	{
		Arrays.sort(array);
	}
}
