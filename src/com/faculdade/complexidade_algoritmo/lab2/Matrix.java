package com.faculdade.complexidade_algoritmo.lab2;

public class Matrix
{
	private static int[][] matrix = new int[100][100];

	public static void main(String[] args)
	{
		long inicio = 0, fim = 0;

		inicio = System.nanoTime();
		somaMatriz(matrix);
		fim = System.nanoTime();

		System.out.println();
		System.out.println("Tempo: " + (fim - inicio));
	}

	public static void somaMatriz(int[][] matriz)
	{
		// Preenche matriz
		fillMatrix(matriz);

		int instructions = 1;
		
		// Soma coluna
		int[] colunas = new int[matriz[0].length];
		instructions += 1;
		int somaTotal = 0;
		instructions += 1;
		// Soma linha
		int[] linhas = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz[0].length; j++)
			{
				instructions += 1;
				linhas[i] += matriz[i][j];
				instructions += 1;
				colunas[j] += matriz[i][j];
				instructions += 1;
				somaTotal += matriz[i][j];
			}
		}
		

		for (int i = 0; i < linhas.length; i++)
		{
			System.out.println("Linha " + i + ": " + linhas[i]);
		}

		for (int i = 0; i < colunas.length; i++)
		{
			System.out.println("Coluna " + i + ": " + colunas[i]);
		}

		System.out.println("Total Matriz: " + somaTotal);
		
		System.err.println("Total instructions: " + instructions);
	}

	private static void fillMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = i; j < matrix[i].length; j++)
			{
				matrix[i][j] = i + j;
			}
		}
	}

}
