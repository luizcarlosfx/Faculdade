package com.faculdade.topicos_especiais;

public class LinearSystemResolution
{
	public static void main(String[] args)
	{
		double matrix[][] =
			{
				{ 1, -1, 1 },
				{ 1, 2, -1 },
				{ 1, 1, 3 } };

		double results[] =
			{ 0, 8, 6 };

		System.out.print("Resultado = ");
		printVector(resolveLinearSystem(matrix, results));

	}

	private static double[] resolveLinearSystem(double[][] m, double[] results)
	{
		double iconitas[] = new double[m.length];
		double p = 0;
		for (int i = 0; i < m.length; i++)
		{
			for (int j = i + 1; j < m.length; j++)
			{
				p = m[j][i] / m[i][i];
				for (int k = i; k < m[i].length; k++)
				{
					m[j][k] = m[j][k] - p * m[i][k];
				}
			}
		}

		for (int i = iconitas.length - 1; i >= 0; i--)
		{
			double previousTotal = 0;

			for (int j = i; j + 1 < iconitas.length; j++)
			{
				previousTotal += (m[i][j + 1] * iconitas[j + 1]);
			}

			iconitas[i] = (results[i] - previousTotal) / m[i][i];
		}

		return iconitas;
	}

	public static void printVector(double[] m)
	{
		for (double d : m)
		{
			System.out.print("|" + d);
		}

		System.out.println("|");
	}
}
