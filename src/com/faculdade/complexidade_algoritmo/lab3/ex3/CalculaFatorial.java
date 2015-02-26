package com.faculdade.complexidade_algoritmo.lab3.ex3;

public class CalculaFatorial extends Thread
{
	private int number;
	public double result;
	public CalculaFatorial(int number)
	{
		super();
		this.number = number;
		result = number;
	}
	
	@Override
	public void run()
	{
		for (int i = number - 1; i > 1; i--)
		{
			result *= number;
		}
	}
}
