package com.faculdade.pesquisa_ordenacao.grafo;

public class Info

{
	String valor;
	public Info(String v)
	{
		valor=v;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return valor.equals(obj.toString());
	}

}
