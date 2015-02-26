package com.faculdade.games.lab2.ex4;

public class Multiplo
{
	public static void main(String[] args)
	{
		System.out.println(multiplo(2, 1));
		System.out.println(multiplo(1, 2));
		System.out.println(multiplo(3, 2));
		System.out.println(multiplo(6, 15));
		System.out.println(multiplo(15, 3));
	}
	
	static boolean multiplo(int a, int b)
	{
		return a % b == 0;
	}
}
