package com.faculdade.compiladores.aula;

public class LexicalAnalyzer
{
	private StringIterator iterator;

	private Token current;

	private int line;

	private void removeWhiteSpace()
	{
		String next = iterator.current();

		while (CompilerUtils.isWhitespace(next))
		{
			next = iterator.next();

			if (CompilerUtils.isLineBreak(next))
			{
				line = line + 1;
			}
		}
	}

	private Token getNumberToken()
	{
		String next = iterator.current();

		String temp = "";
		do
		{
			temp += next;
			next = iterator.next();
		}
		while (CompilerUtils.isDigit(next));

		return new Token(temp, Token.NUMBER);
	}

	private Token getOperatorToken()
	{
		String next = iterator.current();

		String character = next;

		next = iterator.next();

		return new Token("", character);
	}

	private Token getIdToken()
	{
		String temp = "";

		String next = iterator.current();

		do
		{
			temp += next;
			next = iterator.next();
		}
		while (CompilerUtils.isLetter(next) || CompilerUtils.isDigit(next));

		return new Token(temp, Token.ID);
	}

	public LexicalAnalyzer(String expression)
	{
		iterator = new StringIterator(expression);
		nextToken();
	}

	/*
	 * public List<Token> getTokens(String expression) { List<Token> tokens =
	 * new ArrayList<Token>();
	 * 
	 * StringIterator iterator = new StringIterator(expression);
	 * 
	 * Token currentToken;
	 * 
	 * do { currentToken = nextToken(iterator);
	 * 
	 * if (currentToken == null) break;
	 * 
	 * tokens.add(currentToken); } while (true);
	 * 
	 * return tokens; }
	 */
	public int getLine()
	{
		return line;
	}

	public Token current()
	{
		return current;
	}

	public boolean finalized()
	{
		return current == null;
	}

	public Token nextToken()
	{
		// Remove espaços em branco, tabs e quebras de linha
		removeWhiteSpace();

		if (iterator.current() == null)
		{
			return current = null;
		}

		if (CompilerUtils.isDigit(iterator.current()))
		{
			// Obtem um token a partir de uma sequencia de números
			return current = getNumberToken();
		}
		else if (CompilerUtils.isLetter(iterator.current()))
		{
			// Obtem um token a partir de uma sequencia de letras
			return current = getIdToken();
		}
		else
		{
			String currentSt = iterator.current();

			if (CompilerUtils.isOperator(currentSt) || CompilerUtils.isParenthesis(currentSt))
			{
				// retorna o token de um operador (+,-, *,/) ou de um abre ou
				// fechar parentesis
				current = getOperatorToken();
				
				return current;
			}

			return	current = null;
		}
	}
}
