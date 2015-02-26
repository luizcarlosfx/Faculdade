package com.faculdade.linguagem_programacao.lab13;

public class HighLander {
	private static HighLander instance;

	public static synchronized HighLander getInstance(){
		return instance;
	}
	
	private HighLander(){
		super();
	}
}
