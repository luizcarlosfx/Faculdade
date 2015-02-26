package com.faculdade.linguagem_programacao.lab13;

public class Factory {
	public static void main(String[] args) {
		HighLander h1, h2, h3;
		//h1 = new HighLander();
		h2 = HighLander.getInstance();
		h3 = HighLander.getInstance();
		
		if(h2 == h3){
			System.out.println("H2 é igual à H3");
		}
	}
}
