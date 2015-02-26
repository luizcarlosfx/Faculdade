package com.faculdade.compiladores.trabalho;

import java.util.Iterator;

public class StringIterator implements Iterator<String>
{
	private String expression;

	private int index = -1;

	private String current = " ";

	public StringIterator(String expression)
	{
		this.expression = expression;
	}

	public String getExpression()
	{
		return this.expression;
	}

	public String current()
	{
		return current;
	}

	@Override
	public boolean hasNext()
	{
		return index + 1 < expression.length();
	}

	@Override
	public String next()
	{
		if (!hasNext())
			current = null;
		else
			current = expression.charAt(++index) + "";
		
		return current;
	}
}