package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Middleware extends UnicastRemoteObject implements IMiddleware
{
	protected Middleware() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	private static List<String> ips = new ArrayList<String>();

	public static void main(String[] args)
	{
		try
		{
			Registry registry = LocateRegistry.createRegistry(1101);
			IMiddleware middleware = new Middleware();
			registry.bind("middleware", middleware);

			int numServers = Integer.parseInt(JOptionPane.showInputDialog("Quantos servidores?"));

			for (int i = 1; i <= numServers; i++)
			{
				String ip = JOptionPane.showInputDialog("Enter the ip");
				ips.add(ip);
				System.out.println(ips);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public IAccountProvider getAccount() throws RemoteException
	{
		for (String ip : ips)
		{
			System.out.println(ip);
			try
			{
				Registry r = LocateRegistry.getRegistry(ip, 1100);
				IServer server = (IServer) r.lookup("service");
				IAccountProvider account = server.getAccountProvider();
				return account;
			}
			catch (Exception e)
			{

			}
		}

		return null;
	}
}
