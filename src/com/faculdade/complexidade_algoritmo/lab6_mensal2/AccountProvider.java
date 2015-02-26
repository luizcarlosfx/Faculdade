package com.faculdade.complexidade_algoritmo.lab6_mensal2;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountProvider extends UnicastRemoteObject implements IAccountProvider
{
	private Account account;
	
	public AccountProvider() throws RemoteException
	{
		super();
	}
	
	public AccountProvider(Account account) throws RemoteException
	{
		this();
		this.setAccount(account);
	}

	@Override
	public void deposit(double ammount) throws RemoteException
	{
		account.deposit(ammount);
	}

	@Override
	public boolean draw(double ammount) throws RemoteException
	{
		System.out.println(account);
		return account.draw(ammount);
	}

	@Override
	public double getBalances()
	{
		return account.getBalance();
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}
}
