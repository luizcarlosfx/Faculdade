package com.faculdade.compiladores.trabalhov2;

import javax.swing.JOptionPane;

public class Main
{
	public static void main(String [] args)
	{
		String expressao = JOptionPane.showInputDialog("Entre com uma express�o aritm�tica");
		
		System.out.println("Express�o = " + expressao);
        
		Reversa reversa = new Reversa(expressao);
		
		reversa.parse();
	}
}
