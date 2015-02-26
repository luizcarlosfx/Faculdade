package com.faculdade.complexidade_algoritmo.lab1;

public class Search
{
	private static int instructions;
	public static void main(String[] args)
	{
		int array[] = Sort.inverseArray(1000);
		binarySearch(array, array.length);
		System.out.println("Instructions: " + instructions);
		binarySearch(array, array.length/2);
		System.out.println("Instructions: " + instructions);
		int random = (int)(Math.random() * 1000);
		System.out.println(random);
		binarySearch(array, random);
		System.out.println("Instructions: " + instructions);
		binarySearch(array, array.length + 1);
		System.out.println("Instructions: " + instructions);
	}

	public static int binarySearch(int[] array, int element)
	{
		instructions = 0;
		int begin = 0, end = array.length - 1, middle = 0;
		instructions += 3;
		while (begin <= end)
		{
			middle = (begin + end) / 2;
			instructions += 1;
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
			instructions += 2;
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
