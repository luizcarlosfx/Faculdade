package com.faculdade.sistemas_distribuidos.lab4.maior;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMaior extends Remote
{
	public double maior(double a, double b) throws RemoteException;
}
