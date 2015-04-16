package com.faculdade.sistemas_distribuidos.lab4.strings;

/*
 * Java em Rede
 * Daniel Gouveia Costa
 *
 * Exemplo 6.8
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMIPessoa
{
	static public void main(String rmi[])
	{
		try
		{
			String localizacao = "pessoa";

			Registry r = LocateRegistry.getRegistry("localhost", 2555);

			InterfaceRMIPessoa objeto = (InterfaceRMIPessoa) r.lookup(localizacao);

			while (true)
			{
				Pessoa pessoa = (Pessoa) objeto.retornarPessoa();
				System.out.println("Nome da pessoa: " + pessoa.getNome());
				System.out.println("Idade: " + pessoa.getIdade() + "\n");
				Thread.sleep(4000);
			}
		}
		catch (Exception exc)
		{
			System.err.println(exc.toString());
		}
	}
}