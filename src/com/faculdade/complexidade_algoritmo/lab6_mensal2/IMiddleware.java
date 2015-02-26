package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddleware extends Remote
{
	public IAccountProvider getAccount() throws RemoteException;
}
