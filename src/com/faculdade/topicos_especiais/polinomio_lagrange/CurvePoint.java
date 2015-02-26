package com.faculdade.topicos_especiais.polinomio_lagrange;

public class CurvePoint
{
	private double time;
	private double value;

	public CurvePoint(double time, double value)
	{
		super();
		this.time = time;
		this.value = value;
	}

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}
}
