package com.faculdade.complexidade_algoritmo.lab5;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculaOne extends UnicastRemoteObject implements ICalculaOne
{
	protected CalculaOne() throws RemoteException
	{
		
	}

	@Override
	public double calcula(double x)
	{
		return Math.pow(x, 2) + 1;
	}
}
