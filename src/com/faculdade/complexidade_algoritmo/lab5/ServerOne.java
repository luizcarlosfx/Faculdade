package com.faculdade.complexidade_algoritmo.lab5;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ServerOne
{
	public static void main(String[] args) throws MalformedURLException, RemoteException,
			AlreadyBoundException
	{
		Registry registry = LocateRegistry.createRegistry(1099);
		ICalculaOne calculaOne = new CalculaOne();

		try
		{
			registry.bind("calculaone", calculaOne);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
