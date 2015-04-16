package com.faculdade.sistemas_distribuidos.lab4.maior;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MaiorCliente
{
	public static void main(String[] args) throws RemoteException, NotBoundException
	{
		Registry r = LocateRegistry.getRegistry(2555);
		
		
		IMaior maior = (IMaior) r.lookup("maior");
		
		System.out.println(maior.maior(5, 4));
	}
}
