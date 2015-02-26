package com.faculdade.complexidade_algoritmo.lab6_mensal2;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAccountProvider extends Remote
{
	void deposit(double ammount) throws RemoteException;
	boolean draw(double ammount) throws RemoteException;
	double getBalances() throws RemoteException;
}
