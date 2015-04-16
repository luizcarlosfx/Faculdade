package com.faculdade.sistemas_distribuidos.lab4.mensageiro;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MensageiroClient
{

	public MensageiroClient()
	{
	}

	public static void main(String args[])
	{
		try
		{
			Registry r = LocateRegistry.getRegistry(2555);
			Mensageiro m = (Mensageiro) r.lookup("MensageiroService");
			System.out.println(m.lerMensagem());
			m.enviarMensagem("Hello World!");
		}
		catch (Exception e)
		{
			System.out.println();
			System.out.println("MalformedURLException: " + e.toString());
		}
	}
}