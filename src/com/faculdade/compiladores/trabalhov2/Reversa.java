/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.compiladores.trabalhov2;


/**
 *
 * @author professores
 */

public class Reversa
{
	private cToken lookahead;
	private Reversa2 analisadorLexico;

	public Reversa(String expressao)
	{
		this.analisadorLexico = new Reversa2(expressao);
		this.lookahead = analisadorLexico.analex();
	}

	private void expr()
	{
		termo();
		r();
	}

	private void termo()
	{
		fator();
		r2();
	}

	private void r()
	{
		if (lookahead == null)
			return;
		
		if (lookahead.getNome().equals("+"))
		{
			match("+");
			termo();
			System.out.print("+ ");
			r();
		}
		else if (lookahead.getNome().equals("-"))
		{
			match("-");
			termo();
			System.out.print("- ");
			r();
		}
	}

	private void r2()
	{
		if (lookahead == null)
			return;
		if (lookahead.getNome().equals("*"))
		{
			match("*");
			fator();
			System.out.print("* ");
			r2();
		}
	}

	private void fator()
	{
		if (lookahead == null)
		{
			erroFator();
		}

		if (lookahead.getNome().equals("num"))
		{
			int valor = lookahead.getValor();
			match("num");
			System.out.printf("%s ", valor);
		}
		else if (lookahead.getNome().equals("id"))
		{
			String lexema = lookahead.getLexema();
			match("id");
			System.out.printf("%s ", lexema);
		}
		else if (lookahead.getNome().equals("("))
		{
			match("(");
			expr();
			match(")");
		}
		else
		{
			erroFator();
		}
	}

	private void erroFator()
	{
		System.out.println("Erro (2) - Esperando um id, numero ou abre parêntesis \"(\" ");
		System.exit(0);
	}

	private void match(String token)
	{
		if (lookahead != null && lookahead.getNome().equals(token))
		{
			lookahead = analisadorLexico.analex();
		}
		else
		{
			System.out.println("Erro (3) - exprerando " + token);
			System.exit(0);
		}
	}

	public void parse()
	{
		expr();
		if (lookahead == null)
		{
			System.out.println("\n\nOK");
		}
		else
		{
			System.out.println("Erro (4) - Não chegou ao final da expressao");
			System.exit(0);
		}
	}
}
