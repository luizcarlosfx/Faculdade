package com.faculdade.linguagem_programacao.lab8;

public class A {
	protected int a;
	protected int b;
	
	public int somar(){
		return a + b;
	}
	
	public void imprimir(){
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "a: " + a + " b: " + b;
	}
}
