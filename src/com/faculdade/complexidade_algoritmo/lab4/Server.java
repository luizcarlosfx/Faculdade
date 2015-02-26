package com.faculdade.complexidade_algoritmo.lab4;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Server
{
	public static void main(String[] args) throws MalformedURLException, RemoteException,
			AlreadyBoundException
	{
		IHello hello = new Hello();

		try
		{
			Naming.bind("//localhost/hello", hello);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
}
