package com.faculdade.compiladores.trabalho;

import javax.swing.JOptionPane;

public class Main
{
	public static void main(String[] args)
	{
		do
		{
			String expression = JOptionPane.showInputDialog("Digite uma express�o aritm�tica");

			System.out.println("Express�o: " + expression + "\n");

			ExpressionParser parser = new ExpressionParser();

			try
			{
				String finalExpression = parser.parseExpression(expression);
				System.out.println("\nOK - Express�o final = " + finalExpression);
			}
			catch (Exception e)
			{
				System.err.println("\n" + e.getMessage());
			}

		}
		while (JOptionPane.showConfirmDialog(null, "Continuar?") == JOptionPane.OK_OPTION);
	}
}
