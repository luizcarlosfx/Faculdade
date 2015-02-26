package com.faculdade.complexidade_algoritmo.lab4;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client
{
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		IHello hello = (Hello) Naming.lookup("hello");
		
		hello.sayHello();
	}
}
