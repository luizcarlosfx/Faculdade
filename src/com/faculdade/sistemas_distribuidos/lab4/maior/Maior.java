package com.faculdade.sistemas_distribuidos.lab4.maior;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Maior extends UnicastRemoteObject implements IMaior
{

	protected Maior() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double maior(double a, double b)
	{
		return a > b ? a : b;
	}
	
}
