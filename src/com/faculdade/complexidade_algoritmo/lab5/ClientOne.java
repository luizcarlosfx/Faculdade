package com.faculdade.complexidade_algoritmo.lab5;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class ClientOne
{
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		Registry rmiRegistry = LocateRegistry.getRegistry("localhost", 1099);
		Registry rmiRegistry2 = LocateRegistry.getRegistry("localhost", 1100);
		ICalculaOne calculaOne = (ICalculaOne) rmiRegistry.lookup("calculaone");
		ICalculaTwo calculaTwo = (ICalculaTwo) rmiRegistry2.lookup("calculatwo");
		
		double x = Integer.valueOf(JOptionPane.showInputDialog("Enter the x value"));
		double result1 = calculaOne.calcula(x);
		double result2 = calculaTwo.calcula(x);
		
		JOptionPane.showMessageDialog(null, "Result: " + result2 / result1);
	}
}
