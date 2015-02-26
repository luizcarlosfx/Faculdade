/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.compiladores.trabalhov2;

/**
 *
 * @author professores
 */
public class cToken
{
	private String nome;
	private int valor;
	private String lexema;

	public cToken(String s, String tipo)
	{
		nome = tipo;
		if (tipo.equals("num"))
		{
			valor = Integer.parseInt(s);
		}
		else if (tipo.equals("id"))
		{
			lexema = s;
		}
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getLexema()
	{
		return this.lexema;
	}

	public int getValor()
	{
		return this.valor;
	}

	public String toString()
	{
		String s;

		s = "<" + nome + ", ";
		if (nome.equals("num"))
		{
			s += valor;
		}
		else if (nome.equals("id"))
		{
			s += lexema;
		}
		s += ">";

		return s;
	}
}
