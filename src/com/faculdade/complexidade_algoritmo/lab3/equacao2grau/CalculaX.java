package com.faculdade.complexidade_algoritmo.lab3.equacao2grau;

public class CalculaX extends Thread
{
	private Type type;
	private double a,b,c;
	private double result;
	private double delta;

	public CalculaX(Type type, double a, double b, double c)
	{
		super();
		this.type = type;
		this.a = a;
		this.b = b;
		this.c = c;
		this.delta = delta;
	}


	@Override
	public void run()
	{
		if(type == Type.X1){
			result = (-b + Math.sqrt(delta))/(2 * a);
		}else {
			result = (-b - Math.sqrt(delta))/(2 * a);
		}
	}


	public double getResult()
	{
		return result;
	}


	public void setResult(double result)
	{
		this.result = result;
	}


	public double getDelta()
	{
		return delta;
	}


	public void setDelta(double delta)
	{
		this.delta = delta;
	}
}

enum Type
{
	X1, X2
}
