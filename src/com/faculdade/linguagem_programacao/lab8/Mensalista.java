package com.faculdade.linguagem_programacao.lab8;

public class Mensalista extends Empregado {
	private Cargo cargo;

	public Mensalista(String nome, String endereco, double salario, Cargo cargo) {
		super(nome, endereco, salario);
		this.cargo = cargo;
	}

	public double calSalario() {
		switch (cargo) {
			case JUNIOR:
				return 3500;
			case PLENO:
				return 4500;
			case SENIOR:
				return 6000;
			default:
				return 0;
		}
	}

	@Override
	public String toString() {
		return "Mensalista [cargo=" + cargo + ", nome=" + nome + ", endereco=" + endereco
				+ ", salario=" + salario + ", calSalario()=" + calSalario() + ", callINSS()="
				+ callINSS() + ", calRPF()=" + calRPF() + "]";
	}
	
}
