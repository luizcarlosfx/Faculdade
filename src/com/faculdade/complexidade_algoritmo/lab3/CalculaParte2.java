package com.faculdade.complexidade_algoritmo.lab3;

public class CalculaParte2 extends Thread
{
	private double x;
	public double result;

	public CalculaParte2(double x)
	{
		this.x = x;
	}

	@Override
	public void run()
	{
		result = x + 5;
	}
}
