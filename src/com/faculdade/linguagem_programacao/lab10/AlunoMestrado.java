package com.faculdade.linguagem_programacao.lab10;

public class AlunoMestrado extends Aluno {

	public AlunoMestrado(String nome, long matricula, double mensalidade) {
		super(nome, matricula, mensalidade);
	}

	@Override
	void imprimir() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "AlunoMestrado [nome=" + nome + ", matricula=" + matricula + ", mensalidade="
				+ mensalidade + "]";
	}
}
