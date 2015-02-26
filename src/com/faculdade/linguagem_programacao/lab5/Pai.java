package com.faculdade.linguagem_programacao.lab5;


public class Pai {
	public Pai() {
		doStuff();
	}
	
	public void doStuff(){
		System.out.println("Pai");
	}
	
}
class Filho extends Pai{
	private int x = 2;
	
	@Override
	public void doStuff() {
		System.out.println(x);
	}
}
