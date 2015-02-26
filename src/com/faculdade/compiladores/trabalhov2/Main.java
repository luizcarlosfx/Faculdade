package com.faculdade.compiladores.trabalhov2;

import javax.swing.JOptionPane;

public class Main
{
	public static void main(String [] args)
	{
		String expressao = JOptionPane.showInputDialog("Entre com uma expressão aritmética");
		
		System.out.println("Expressão = " + expressao);
        
		Reversa reversa = new Reversa(expressao);
		
		reversa.parse();
	}
}
