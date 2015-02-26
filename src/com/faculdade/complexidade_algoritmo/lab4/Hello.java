package com.faculdade.complexidade_algoritmo.lab4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements IHello
{
	protected Hello() throws RemoteException
	{
		
	}

	@Override
	public String sayHello()
	{
		return "Vai Corinthians";
	}
}
