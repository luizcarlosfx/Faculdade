package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class MainAccountProvider
{
	public static final String NAME = "account";

	public static void main(String[] args)
	{
		try
		{
			Registry registry = LocateRegistry.createRegistry(1099);
			IAccountProvider accountProvider = new AccountProvider(new Account(100000,
					"Luiz Carlos"));
			registry.bind(NAME, accountProvider);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
