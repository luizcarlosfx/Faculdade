package com.faculdade.automatos;

import javax.swing.JOptionPane;


public class TestRegex
{
	private static String []regexes = {"((b(a*)b)*)|a(a|b)((a|b)(a|b))*","(a|b)a*b+(a+b)*","","",""}; 
	public static void main(String[] args)
	{
		String word = JOptionPane.showInputDialog("Type the word");
		int regexOption = Integer.parseInt(JOptionPane.showInputDialog("Regex number"));
		System.out.println(word.matches(regexes[regexOption]) ? "Válido": "Inválido");
	}
}
