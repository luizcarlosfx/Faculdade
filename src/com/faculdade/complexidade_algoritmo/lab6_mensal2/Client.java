package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import com.faculdade.complexidade_algoritmo.lab5.ICalculaTwo;

public class Client
{
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		String ip = JOptionPane.showInputDialog("Ip");
		Registry rmiRegistry = LocateRegistry.getRegistry(ip, 1101);
		IMiddleware middleware = (IMiddleware) rmiRegistry.lookup("middleware");
		
		System.out.println(middleware.getAccount());
		IAccountProvider account = middleware.getAccount();
		
		account.draw(1000);
		
		System.out.println(account.getBalances());
		
		account.deposit(1);
		
		System.out.println(account.getBalances());
	}
}
