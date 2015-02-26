package com.faculdade.linguagem_programacao.lab10;

public class TestaTransacao {
	
	public static void main(String[] args) {		
		ICalculaTransacao calculaTransacaoAVista = new TransacaoAVista(10, "30/06/2013",50);
		ICalculaTransacao calculaTransacaoAPrazo = new TransacaoAPrazo(10, "10/10/10", 75);
		
		Transacao trAvista = (TransacaoAVista) calculaTransacaoAVista;
		Transacao trPrazo = (TransacaoAPrazo) calculaTransacaoAPrazo;
		
		addItems(trAvista);
		addItems(trPrazo);
		
		trAvista.Imprimir();
		trPrazo.Imprimir();
	}
	
	static void addItems(Transacao tr){
		
		for(int i = 0; i < 10; i++){
			tr.addItem(new Item(i, i, i * 10));
		}
	}
}
