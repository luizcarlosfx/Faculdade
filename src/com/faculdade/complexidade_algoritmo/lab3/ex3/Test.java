package com.faculdade.complexidade_algoritmo.lab3.ex3;

public class Test
{
	public static void main(String[] args) throws InterruptedException
	{
		double x = 2;

		Calculo calculo = new Calculo(Math.pow(x, 3), (2 * Math.pow(x, 2)) - 1, Operator.SUM);
		Calculo calculo2 = new Calculo(Math.pow(x, 2), 1, Operator.SUM);
		CalculaFatorial fatorial = new CalculaFatorial((int) x);
		Calculo calculo3 = new Calculo(x, 1, Operator.SUM);

		calculo.start();
		calculo.join();

		calculo2.start();
		calculo2.join();

		fatorial.start();
		fatorial.join();

		calculo3.start();
		calculo3.join();
		
		Calculo calculo4 = new Calculo(fatorial.result, calculo3.result, Operator.DIV);
		calculo4.start();
		calculo4.join();
		
		Calculo calculo5 = new Calculo(calculo.result, calculo2.result, Operator.DIV);
		calculo5.start();
		calculo5.join();

		Calculo calculo6 = new Calculo(calculo4.result, calculo5.result, Operator.SUM);
		calculo6.start();
		calculo6.join();

		System.out.println(calculo6.result);
	}
}
