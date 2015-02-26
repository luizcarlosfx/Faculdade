package com.faculdade.complexidade_algoritmo.lab5;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculaTwo extends UnicastRemoteObject implements ICalculaTwo
{
	protected CalculaTwo() throws RemoteException
	{
		
	}

	@Override
	public double calcula(double x)
	{
		return Math.pow(x, 3) - 1;
	}
}
