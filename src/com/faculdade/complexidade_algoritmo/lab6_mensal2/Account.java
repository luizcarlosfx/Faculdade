package com.faculdade.complexidade_algoritmo.lab6_mensal2;

import java.rmi.RemoteException;

public class Account
{
	private double balance;
	private String clientName;

	public Account(double balance, String clientName)
	{
		super();
		this.balance = balance;
		this.clientName = clientName;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public String getClientName()
	{
		return clientName;
	}

	public void setClientName(String clientName)
	{
		this.clientName = clientName;
	}
	
	public void deposit(double ammount)
	{
		balance += ammount;
	}

	public boolean draw(double ammount)
	{
		if(canDraw(ammount))
		{
			balance -= ammount;
			return true;
		}else
		{
			return false;
		}
	}

	public double getBalances()
	{
		return getBalance();
	}

	public boolean canDraw(double ammount)
	{
		return balance >= ammount;
	}
}
