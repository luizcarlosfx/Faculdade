package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

public class Server extends UnicastRemoteObject implements IServer
{
	private String ip;
	private int port;
	private String objName;
	private AccountProvider accountProvider;

	private Registry rmiRegistry;

	public Server() throws RemoteException
	{
		
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getObjName()
	{
		return objName;
	}

	public void setObjName(String objName)
	{
		this.objName = objName;
	}

	public IAccountProvider getAccountProvider() throws RemoteException, NotBoundException
	{
		Registry rmiRegistry = LocateRegistry.getRegistry(accountProviderIp, 1099);
		return (IAccountProvider) rmiRegistry.lookup("account");
	}

	public void setAccountProvider(AccountProvider accountProvider)
	{
		this.accountProvider = accountProvider;
	}

	public String getIp()
	{
		return ip;
	}
	
	public static void main(String[] args)
	{
		Registry registry;
		try
		{
			registry = LocateRegistry.createRegistry(1100);
			IServer server = new Server();
			registry.bind("service", server);
			accountProviderIp = JOptionPane.showInputDialog("ip do account provider");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String accountProviderIp;
}
