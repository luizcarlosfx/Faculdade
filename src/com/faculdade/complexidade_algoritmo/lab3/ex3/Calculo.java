package com.faculdade.complexidade_algoritmo.lab3.ex3;


public class Calculo extends Thread
{
	private double operando1, operando2;
	private Operator operator;
	public double result;

	public double getResult()
	{
		return result;
	}

	public void setResult(double result)
	{
		this.result = result;
	}

	public Calculo(double operando1, double operando2, Operator operator)
	{
		super();
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.operator = operator;
	}

	@Override
	public void run()
	{
		switch (operator)
		{
			case SUM:
				result = operando1 + operando2;
				break;
			case SUB:
				result = operando1 - operando2;
				break;
			case MULT:
				result = operando1 * operando2;
				break;
			case DIV:
				result = operando1 / operando2;
				break;
		}
	}
}

enum Operator
{
	SUM, SUB, DIV, MULT
}
