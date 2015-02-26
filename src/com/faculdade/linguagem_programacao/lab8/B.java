package com.faculdade.linguagem_programacao.lab8;

public class B extends A{
	protected int c;
	protected int d;
	
	public void imprimir(){
		System.out.println(this);
	}
	
	@Override
	public int somar() {
		// TODO Auto-generated method stub
		return super.somar() + c + d;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "c: " + c + "d: " + d;
	}
}
