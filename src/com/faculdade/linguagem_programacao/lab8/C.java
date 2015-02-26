package com.faculdade.linguagem_programacao.lab8;

public class C extends B{

	protected int e;
	protected int f;
	
	@Override
	public int somar() {
		// TODO Auto-generated method stub
		return super.somar() + e + f;
	}
	
	@Override
	public void imprimir() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return super.toString() + "C [e=" + e + ", f=" + f + "]";
	}

}
