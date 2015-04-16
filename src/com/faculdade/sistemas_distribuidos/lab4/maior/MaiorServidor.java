package com.faculdade.sistemas_distribuidos.lab4.maior;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaiorServidor
{
	public static void main(String[] args)
	{
		try
		{
			Registry r = LocateRegistry.createRegistry(2555);

			IMaior maior = new Maior();

			r.bind("maior", maior);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
