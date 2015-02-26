package com.faculdade.topicos_especiais;

public class ZeroDaFuncao
{
	public static void main(String[] args)
	{
		/*raiz(-2, 20);*/
		
		System.out.println("f(x) = " + f(-1.1212169051251504));
		System.out.println("h(x) = " + h(-1.1212169051251504));
	}

	public static double f(double x)
	{
		// aqui viria um polinomio menos outro
		
		// ex:
		return (Math.pow(x, 2) * 5) - (x * x * x);
	}
	
	public static double h(double x)
	{
		return (-2 * (x * x * x)) + ((x * x)) - 5;
	}
	
	public static double calculaM(double x1, double x2, double y1, double y2)
	{
		return (y1 - y2) / (x1 - x2);
	}
	
	public static double calculateNewX(double m, double x1, double y1)
	{
		return ((m * x1) - y1) / m;
	}

	public static void raiz(double a, double b)
	{
		double erro = 0.001;

		// metade
		double x1 = (a + b) / 2;

		// metade entre meio e fim
		double x2 = (x1 + b) / 2;

		double y = -1;

		while (Math.abs(y) > erro)
		{
			double y1 = f(x1);
			double y2 = f(x2);

			double m = calculaM(x1, x2, y1, y2);

			double newX = calculateNewX(m, x1, y1);
			
			y = f(newX);
			
			x1 = x2;
			
			x2 = newX;
			
			System.out.println("x = " + newX + ", y = " + y);
		}
	}
}
