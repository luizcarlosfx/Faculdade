package com.faculdade.complexidade_algoritmo.lab3.equacao2grau;

public class TestaEquacao
{
	public static void main(String[] args) throws InterruptedException
	{
		double a = 1, b = -5, c = 6;
		CalculaDelta calculaDelta = new CalculaDelta(a, b, c);
		CalculaX calculaX1 = new CalculaX(Type.X1, a, b, c);
		CalculaX calculaX2 = new CalculaX(Type.X2, a, b, c);
		
		calculaDelta.start();
		calculaDelta.join();
		
		calculaX1.setDelta(calculaDelta.getDelta());
		calculaX2.setDelta(calculaDelta.getDelta());
		
		calculaX1.start();
		calculaX2.start();
		
		calculaX1.join();
		calculaX2.join();
		
		System.out.println(calculaX1.getResult());
		System.out.println(calculaX2.getResult());
	}
}
