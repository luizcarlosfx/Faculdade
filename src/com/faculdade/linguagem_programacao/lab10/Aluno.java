package com.faculdade.linguagem_programacao.lab10;

public abstract class Aluno {
	protected String nome;
	protected long matricula;
	protected double mensalidade;
	
	
	public Aluno(String nome, long matricula, double mensalidade) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.mensalidade = mensalidade;
	}

	abstract void imprimir();
	
}
