package com.faculdade.complexidade_algoritmo.lab5;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculaOne extends Remote
{
	double calcula(double x) throws RemoteException;
}
