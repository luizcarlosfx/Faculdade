package com.faculdade.compiladores.aula;

public class Token
{
	private String name;
	private int value;
	private String lexeme;
	
	public static final String NUMBER = "num";
	public static final String ID = "id";

	public Token(String value, String name)
	{
		this.name = name;
		if (name.equals(NUMBER))
		{
			this.value = Integer.parseInt(value);
		}
		else if (name.equals(ID))
		{
			this.lexeme = value;
		}
	}

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;
	}

	public String getLexeme()
	{
		return lexeme;
	}

	public void printValue()
	{
		if (name.equalsIgnoreCase(NUMBER))
		{
			System.out.print(getValue() + " ");
		}
		else if (name.equalsIgnoreCase(ID))
		{
			System.out.print(getLexeme() + " ");
		}
		else
		{
			System.out.print(getName() + " ");
		}
	}
	
	public String getContent()
	{
		if (name.equalsIgnoreCase(NUMBER))
		{
			return getValue() + " ";
		}
		else if (name.equalsIgnoreCase(ID))
		{
			return getLexeme() + " ";
		}
		else
		{
			return getName() + " ";
		}
	}
	
	public boolean isNumber()
	{
		return getName().equalsIgnoreCase(NUMBER);
	}
	
	public boolean isId()
	{
		return getName().equalsIgnoreCase(ID);
	}

	public String toString()
	{
		return String.format("Token [%s, %s]", name, name.equalsIgnoreCase("num") ? value
				: lexeme == null ? "" : lexeme);
	}
}
