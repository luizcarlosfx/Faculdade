package com.faculdade.compiladores.trabalho;

public class ExpressionParser
{	
	private LexicalAnalyzer analyzer;

	public String parseExpression(String expression)
	{
		analyzer = new LexicalAnalyzer(expression);

		String finalExpression = expression();

		// Se ainda tem elementos a serem iterados no analyzer

		if (!analyzer.finalized())
		{
			throw new IllegalStateException("Erro 4 - N�o chegou ao final da cadeia de tokens");
		}

		return finalExpression;
	}

	private String expression()
	{
		return termo() + alfa();
	}

	private String termo()
	{
		return fator() + beta();
	}

	private String alfa()
	{
		Token current = analyzer.current();

		if (CompilerUtils.isPlusOrMinus(current))
		{
			match(current.getName());

			return termo() + current.getContent() + alfa();
		}

		return "";
	}

	private String fator()
	{
		Token current = analyzer.current();
		
		if(current == null)
		{
			return "";
		}
		
		if (current.isNumber() || current.isId())
		{
			match(current.getName());

			return current.getContent();
		}
		else if (current.getName().equals("("))
		{
			match(current.getName());

			return expression() + closeParenthesis();
		}
		else
		{
			throw new IllegalStateException(
					String.format("Erro 1 - N�o � um fator (%s)", current));
		}
	}

	private String beta()
	{
		Token current = analyzer.current();

		if (CompilerUtils.isMultiOrDiv(current))
		{
			match(current.getName());
			return fator() + current.getContent() + beta();
		}

		return "";
	}

	private String closeParenthesis()
	{
		Token current = analyzer.current();
		
		// Se � um fecha par�ntesis
		if (current != null && current.getName().equals(")"))
		{
			match(analyzer.current().getName());
		}
		else
		{
			// Caso contr�rio temos um erro
			throw new IllegalStateException("Erro 3 - Faltando fechar par�ntesis");
		}

		return "";
	}

	private void match(String token)
	{
		Token current = analyzer.current();

		if (current.getName().equals(token))
		{
			analyzer.nextToken();
		}
		else
		{
			throw new IllegalStateException("Erro 2 - Token inv�lido " + current + " : " + token);
		}
	}
}
