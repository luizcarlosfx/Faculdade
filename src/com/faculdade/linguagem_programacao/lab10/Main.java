package com.faculdade.linguagem_programacao.lab10;

public class Main {
	public static void main(String[] args) {
		
		Item meuItem = new Item(2, 5, 50);
		
		Transacao aPrazo = new TransacaoAPrazo(1, "07/05/2013", 50);
		aPrazo.addItem(meuItem);
		aPrazo.Imprimir();
		
		Transacao aVista = new TransacaoAVista(3, "07/05/2013", 50);
		aVista.addItem(meuItem);
		aVista.Imprimir();
	}
}
