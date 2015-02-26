package com.faculdade.topicos_especiais;

public class MultiplicaMatriz
{

	public static void main(String[] args)
	{
		double[][] m1 =
			{
				{ 1, 2},
				{ 3, 4 },
				{ 5, 6 } 
			};
		
		double[][] m2 =
			{
				{ 1, 2, 3 },
				{ 4, 5, 6 }
			};

		printMatrix(multiplyMatrix(m1, m2));
	}

	public static double[][] multiplyMatrix(double[][] m1, double[][] m2)
	{
		double[][] result = new double[m1.length][m2[0].length];
		
		for (int line = 0; line < m1.length; line++)
		{
			for (int column = 0; column < m2[0].length; column++)
			{
				for (int i = 0; i < m2.length; i++)
				{
					result[line][column] += m1[line][i] * m2[i][column];
				}
			}
		}

		return result;
	}

	public static void printMatrix(double[][] m)
	{
		for (double[] ds : m)
		{
			for (double d : ds)
			{
				System.out.print("| " + d);
			}
			System.out.println(" |");
		}
	}

}
