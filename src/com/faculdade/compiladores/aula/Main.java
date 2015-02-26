package com.faculdade.compiladores.aula;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Main
{
	static String fileLocation = "source.c";
	static String source = "";
	public static void main(String[] args)
	{
		/*do
		{
			String expression = JOptionPane.showInputDialog("Digite uma express�o aritm�tica");
			
			// Se a express�o n�o foi digitada eu coloco uma padr�o
			if (expression.isEmpty())
				expression = "25*(344 + x1 * \n ((	f3 * (4))))";

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
			
			System.out.println(source);
		}
		while (JOptionPane.showConfirmDialog(null, "Continuar?") == JOptionPane.OK_OPTION);*/
		
		loadFileToExpression();
	}
	
	public static void loadFileToExpression()
	{
		try(BufferedReader reader = new BufferedReader(new FileReader(fileLocation)))
		{
			String line = "";
			
			while((line = reader.readLine()) != null)
			{
				source += line + "\n";
			}
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		System.out.println(source);
	}
}
