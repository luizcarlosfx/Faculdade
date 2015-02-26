package com.faculdade.compiladores.trabalho;

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
	
	public String getContent()
	{
		String result = name.equals(NUMBER) ? getValue() + "" : name.equals(ID) ? getLexeme() : getName();
		return result + " ";
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
