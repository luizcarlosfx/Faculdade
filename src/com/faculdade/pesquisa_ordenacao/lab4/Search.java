package com.faculdade.pesquisa_ordenacao.lab4;

import java.util.Arrays;

import com.faculdade.pesquisa_ordenacao.lab1.Sort;

public class Search
{
	public static void main(String[] args)
	{
		int array[] = Sort.randomArray(10000);
		Sort.selectionSort(array);

		long begin = System.nanoTime();
		int index = binarySearch(array, 4000);
		long end = System.nanoTime();

		System.out.println("Pesquisa Binária");
		System.out.println("Tempo: " + (end - begin));
		System.out.println("Posição: " + index);
		System.out.println();

		System.out.println();

		long begin2 = System.nanoTime();
		int index2 = Arrays.binarySearch(array, 4000);
		long end2 = System.nanoTime();

		System.out.println("Pesquisa Binária Java");
		System.out.println("Tempo: " + (end2 - begin2));
		System.out.println("Posição: " + index2);
		System.out.println();

		begin = System.nanoTime();
		index = sequentialSearch(array, 4000);
		end = System.nanoTime();

		System.out.println("Pesquisa sequencial");
		System.out.println("Tempo: " + (end - begin));
		System.out.println("Posição: " + index);
		System.out.println();

	}

	public static int binarySearch(int[] array, int element)
	{
		int begin = 0, end = array.length - 1, middle = 0;
		while (begin <= end)
		{
			middle = (begin + end) / 2;
			if (element == array[middle])
			{
				return middle;
			}
			else
			{
				if (element < array[middle])
				{
					end = middle - 1;
				}
				else
				{
					begin = middle + 1;
				}
			}
		}
		return -1;
	}

	public static int sequentialSearch(int[] array, int element)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (element == array[i])
			{
				return i;
			}
		}
		return -1;
	}
}
