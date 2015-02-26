package com.faculdade.compiladores.trabalho;

import java.util.Arrays;
import java.util.List;

public final class CompilerUtils
{
	private static List<String> operators = Arrays.asList("+", "-", "*", "/");

	public static boolean isDigit(String character)
	{
		// Verifica se é um digito
		return (character != null) && character.matches("\\d");
	}

	public static boolean isLetter(String character)
	{
		// Verifica se é uma letra
		return (character != null) && character.matches("[a-zA-Z]");
	}

	public static boolean isWhitespace(String character)
	{
		// Verifica se não é um espaço em branco, tab ou quebra de linha
		return (character != null) && character.matches("\\s");
	}

	public static boolean isLineBreak(String character)
	{
		return (character != null) && character.matches("\\n");
	}

	public static boolean isOperator(String character)
	{
		return operators.contains(character);
	}

	public static boolean isParenthesis(String character)
	{
		return character != null && (character.equals("(") || character.equals(")"));
	}

	public static boolean isPlusOrMinus(Token token)
	{
		return token != null && (token.getName().equals("+") || token.getName().equals("-"));
	}

	public static boolean isMultiOrDiv(Token token)
	{
		return token != null && (token.getName().equals("*") || token.getName().equals("/"));
	}
}
