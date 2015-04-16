package com.faculdade.games.lab6;

public class Ex2
{
	public static void main(String[] args)
	{
		desenhaQuadrado(10);
	}

	static void desenhaQuadrado(int lado)
	{
		for (int i = 1; i <= lado; i++)
		{
			for (int j = 1; j <= lado; j++)
			{
				if (j == 1 || j == lado || i == 1 || i == lado)
				{
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}

			System.out.println();
		}
	}
}
