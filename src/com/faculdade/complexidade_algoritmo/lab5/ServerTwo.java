package com.faculdade.complexidade_algoritmo.lab5;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ServerTwo
{
	public static void main(String[] args) throws MalformedURLException, RemoteException,
			AlreadyBoundException
	{
		Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1100);
		ICalculaTwo calculaTwo = new CalculaTwo();

		try
		{
			registry.bind("calculatwo", calculaTwo);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
