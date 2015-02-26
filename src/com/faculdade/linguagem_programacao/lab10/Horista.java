	package com.faculdade.linguagem_programacao.lab10;

public class Horista extends Empregado implements ICalcula{
	
	private int horas;

	public Horista(String nome, String endereco, double salario, int horas) {
		super(nome, endereco, salario);
		this.horas = horas;
	}
	
	public double calSalario(){
		return horas * 50;
	}
	@Override
	public String toString() {
		return "Horista [horas=" + horas + ", nome=" + nome + ", endereco=" + endereco
				+ ", salario=" + salario + ", calSalario()=" + calSalario() + ", callINSS()="
				+ callINSS() + ", calRPF()=" + calRPF() + "]";
	}
}
