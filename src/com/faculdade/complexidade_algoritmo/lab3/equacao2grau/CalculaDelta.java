package com.faculdade.complexidade_algoritmo.lab3.equacao2grau;

public class CalculaDelta extends Thread
{
	private double a,b,c;
	private double delta;
	
	
	public double getDelta()
	{
		return delta;
	}

	public void setDelta(double delta)
	{
		this.delta = delta;
	}

	public CalculaDelta(double a, double b, double c)
	{
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public void run()
	{
		delta = Math.pow(b, 2) - 4 * (a * c);
	}
}
