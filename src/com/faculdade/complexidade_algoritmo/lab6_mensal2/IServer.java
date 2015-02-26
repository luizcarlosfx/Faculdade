package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote
{
	IAccountProvider getAccountProvider() throws RemoteException, NotBoundException;
}
