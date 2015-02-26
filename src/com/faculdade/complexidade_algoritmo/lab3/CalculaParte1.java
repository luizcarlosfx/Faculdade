package com.faculdade.complexidade_algoritmo.lab3;

public class CalculaParte1 extends Thread
{

	public double result;
	private double x;

	public CalculaParte1(double x)
	{
		this.x = x;
	}

	@Override
	public void run()
	{
		result = x - 1;
	}
}
