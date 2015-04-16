package com.faculdade.sistemas_distribuidos.lab4.strings;

/*
 * Java em Rede
 * Daniel Gouveia Costa
 *
 * Exemplo 6.2
 *
 */

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.util.Date;

import com.faculdade.complexidade_algoritmo.lab6_mensal2.IServer;

public class ServidorRMIString extends UnicastRemoteObject implements InterfaceRMIString
{
	public ServidorRMIString() throws RemoteException
	{
		super();
	}

	static public void main(String... args)
	{
		try
		{
			ServidorRMIString objetoServidor = new ServidorRMIString();
			Registry r = LocateRegistry.createRegistry(2555);
			r.bind("data", objetoServidor);
		}
		catch (Exception exc)
		{
			System.err.println(exc.toString());
		}
	}

	public String getData()
	{
		String data = new Date().toString();
		return data;
	}

}