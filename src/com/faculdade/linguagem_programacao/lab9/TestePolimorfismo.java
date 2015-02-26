package com.faculdade.linguagem_programacao.lab9;

import com.faculdade.linguagem_programacao.lab8.Cargo;
import com.faculdade.linguagem_programacao.lab8.Empregado;
import com.faculdade.linguagem_programacao.lab8.Horista;
import com.faculdade.linguagem_programacao.lab8.Mensalista;

public class TestePolimorfismo {
	public static void main(String[] args) {
		Empregado horista = new Horista("Luiz Carlos Horista", "Rua Rua", 50, 2);
		horista.imprimir();
		
		Empregado mensalista = new Mensalista("Luiz Carlos Mensalista", "Rua Mensalista", 1000, Cargo.JUNIOR);
		mensalista.imprimir();
	}
}
