package com.faculdade.games.lab6;

public class Ex3
{
	public static void main(String[] args)
	{
		System.out.println(trianguloRetangulo(3, 4, 5));
	}

	static boolean trianguloRetangulo(double adjacente, double oposto, double hipotenusa)
	{
		return (adjacente * adjacente + oposto * oposto == hipotenusa * hipotenusa);
	}
}
