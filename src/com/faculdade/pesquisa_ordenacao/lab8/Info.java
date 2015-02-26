package com.faculdade.pesquisa_ordenacao.lab8;

class Info

{
	String valor;
	public Info(String v)
	{
		valor=v;

	}

	public void Imprimir()
	{
		System.out.println("info ="+ valor);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valor;
	}

}
