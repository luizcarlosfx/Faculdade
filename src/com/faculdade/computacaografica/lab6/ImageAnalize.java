package com.faculdade.computacaografica.lab6;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ImageAnalize
{
	private Map<Integer, Integer> ocurrences = new TreeMap<Integer, Integer>();

	private Map<Integer, Double> histogram = new TreeMap<Integer, Double>();

	private int colors = 16;

	private int[][] imageMatrix = generateMatrix(colors, 64, 32);

	public ImageAnalize()
	{
		calculateOcurrences();
	}
	
	private int[][] generateMatrix(int colors, int pixelsH, int pixelsV)
	{
		int[][] matrix = new int[pixelsH][pixelsV];

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = (int) Math.floor(Math.random() * 16);
			}
		}
		return matrix;
	}
	
	public int[][] getImageMatrix()
	{
		return this.imageMatrix;
	}

	private void calculateOcurrences()
	{
		for (int[] line : imageMatrix)
		{
			for (int value : line)
			{
				if (ocurrences.containsKey(value))
				{
					ocurrences.replace(value, ocurrences.get(value) + 1);
					
				}
				else
				{
					ocurrences.put(value, 1);
				}
			}
		}
	}

	public Map<Integer, Double> generateHistogram()
	{
		ocurrences.forEach((value, occurrence) -> histogram.put(value,
				(occurrence / (double) (imageMatrix.length * imageMatrix[0].length)) * 100));

		return histogram;
	}

	public int getModa()
	{
		int mostOcurrences = -1;

		for (Integer value : ocurrences.keySet())
		{
			if (mostOcurrences == -1)
			{
				mostOcurrences = value;
			}
			else if (ocurrences.get(mostOcurrences) < ocurrences.get(value))
			{
				mostOcurrences = value;
			}
		}

		return mostOcurrences;
	}

	public double getAverage()
	{
		double soma = 0;
		
		for (Integer color : ocurrences.keySet())
		{
			soma += ocurrences.get(color) * color;
		}
		
		return soma / (imageMatrix.length * imageMatrix[0].length);
	}

	public int getMediana()
	{
		return (int)Math.ceil(ocurrences.keySet().stream().collect(Collectors.averagingInt(Integer::intValue)));
	}
	
	public void printOcurrences()
	{
		ocurrences.forEach((color, ocurrence) -> System.out.printf("Color: %s, Ocurrences: %s\n", color, ocurrence));
	}
}
