package com.faculdade.topicos_especiais;

public class Integral
{
	public static void main(String[] args)
	{
		System.out.println(cauculaIntegral(1/3f));
	}

	public static double cauculaIntegral(double tempo)
	{
		double area = 0;

		double delta = 1;

		double i = 0;

		while (i + delta < tempo)
		{
			double x1 = f(i);

			i += delta;

			double x2 = f(i);

			area += ((x1 + x2) * delta) / 2;
		}

		area += ((f(i) + f(tempo)) * delta) / 2;

		System.out.println(((f(i) + f(tempo)) * delta) / 2 + ", i=" + i);

		return area;
	}

	public static double f(double x)
	{
		return x * 120;
	}
}
