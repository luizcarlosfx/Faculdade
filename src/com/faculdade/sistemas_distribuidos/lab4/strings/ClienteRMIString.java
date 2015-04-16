package com.faculdade.sistemas_distribuidos.lab4.strings;

/*
 * Java em Rede
 * Daniel Gouveia Costa
 *
 * Exemplo 6.3
 *
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMIString
{
	static public void main(String rmi[])
	{
		try
		{
			String ipRodolfo = "172.17.5.102";
			String meuIp = "172.17.6.201";
			String localhost = "localhost";
			
			Registry r = LocateRegistry.getRegistry(ipRodolfo, 2555);
			
			InterfaceRMIString objeto = (InterfaceRMIString) r.lookup("data");

			System.out.println("A data atual no servidor é: " + objeto.getData());
		}
		catch (Exception exc)
		{
			System.err.println(exc.toString());
		}
	}
}