package com.faculdade.complexidade_algoritmo.lab3;

public class MainEx1
{
	public static void main(String[] args) throws InterruptedException
	{
		double x = 10;
		CalculaParte1 thread1 = new CalculaParte1(x);
		CalculaParte2 thread2 = new CalculaParte2(x);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		double result = thread1.result / thread2.result;
		
		System.out.println(result);
	}
}
